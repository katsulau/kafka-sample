package com.example.kafka_sample.config

import com.example.kafka_sample.handler.DebeziumHandler
import io.debezium.config.Configuration
import io.debezium.engine.DebeziumEngine
import io.debezium.engine.format.ChangeEventFormat
import java.io.File
import org.springframework.context.annotation.Bean


@org.springframework.context.annotation.Configuration
class DebeziumConfig {

    @Bean
    fun debeziumFactory(): Configuration {
        return Configuration.create()
            .with("name", "engine")
            .with("connector.class", "io.debezium.connector.mysql.MySqlConnector")
            .with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
            .with("offset.storage.file.filename", "offset.dat")
            .with("offset.flush.interval.ms", "60000")
            .with("database.hostname", "127.0.0.1")
            .with("database.port", "3306")
            .with("database.dbname", "test")
            .with("database.user", "root")
            .with("database.password", "password")
            .with("database.server.id", "8080")
            .with("topic.prefix", "debezium_app_cdc_topic")
            .with("schema.history.internal", "io.debezium.storage.file.history.FileSchemaHistory")
            .with("schema.history.internal.file.filename", "schemahistory.dat")
            .with("include.schema.change", "false")
            .with("table.include.list", "test.profile")
//            .with("column.include.list", "storeDB.customer.*,storeDB.product.(id|price)")
            .build()
    }
}