package com.example.kafka_sample.handler

import kotlinx.serialization.encodeToString
import com.example.kafka_sample.model.value.PayloadModel
import io.debezium.config.Configuration
import io.debezium.engine.ChangeEvent
import io.debezium.engine.DebeziumEngine
import io.debezium.engine.format.Json
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import java.io.IOException
import java.util.concurrent.Executors
import org.springframework.stereotype.Service

@Service
class DebeziumHandler(
    debeziumConfig: Configuration,
) {
    private val executor = Executors.newSingleThreadExecutor()
    private val engine by lazy {
        DebeziumEngine.create(Json::class.java)
            .using(debeziumConfig.asProperties())
            .notifying(this::handleChangeEvent)
            .build()
    }

    @PostConstruct
    private fun start() = executor.execute { engine.run() }

    @PreDestroy
    @Throws(IOException::class)
    private fun stop() = engine.close()


    private fun handleChangeEvent(event: ChangeEvent<String, String>) {
        // 削除イベンxトの場合、なぜか2回走り、2回目はvalueがない
        if (event.key() == null || event.value() == null) return
        
        println("-------------------------------------------------------------------------------------------------------------------------------------------")
        val format = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
            prettyPrint = true
        }
        // schema有無設定によって、構造が変わる
        val eventModel = format.decodeFromString<PayloadModel>(event.value())
        println(format.encodeToString(eventModel))
        println("-------------------------------------------------------------------------------------------------------------------------------------------")
    }
}