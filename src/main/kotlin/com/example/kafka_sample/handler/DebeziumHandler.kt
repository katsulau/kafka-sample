package com.example.kafka_sample.handler

import io.debezium.config.Configuration
import io.debezium.data.Envelope.FieldName
import io.debezium.data.Envelope.Operation
import io.debezium.embedded.Connect
import io.debezium.engine.DebeziumEngine
import io.debezium.engine.RecordChangeEvent
import io.debezium.engine.format.ChangeEventFormat
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import java.io.IOException
import java.util.concurrent.Executors
import org.apache.kafka.connect.data.Struct
import org.apache.kafka.connect.source.SourceRecord
import org.springframework.stereotype.Service


@Service
class DebeziumHandler(
    debeziumConfig: Configuration,
) {
    private val executor = Executors.newSingleThreadExecutor()
    private val engine by lazy {
        DebeziumEngine.create(ChangeEventFormat.of(Connect::class.java))
            .using(debeziumConfig.asProperties())
            .notifying(this::handleChangeEvent)
            .build()
    }

    @PostConstruct
    private fun start() = executor.execute { engine.run() }

    @PreDestroy
    @Throws(IOException::class)
    private fun stop() = engine.close()


    private fun handleChangeEvent(event: RecordChangeEvent<SourceRecord>) {
        val sourceRecord = event.record()
        val sourceRecordValue = sourceRecord.value() as? Struct ?: return
        val operationCode = try {
            sourceRecordValue.get(FieldName.OPERATION) as? String ?: return
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return
        }
        val operation = Operation.forCode(operationCode)
        if (operation?.code()?.let { "crud".contains(it) } == true) {
            val recordField = if (operation == Operation.DELETE) "before" else "after"
            val struct = sourceRecordValue[recordField] as? Struct ?: return
            val message = struct.schema().fields()
                .asSequence()
                .filter { field -> struct[field.name()] != null }
                .map { field -> field.name() to struct[field.name()] }
                .toMap()
            println("Data Changed: $message with Operation: ${operation.name}")
        }
    }
}