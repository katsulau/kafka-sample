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
            .with("name", "store_mysql_connector")
            .with("connector.class", "io.debezium.connector.mysql.MySqlConnector")
            .with("tasks.max", "1")
            .with("database.server.id", "1")
            .with("database.hostname", "127.0.0.1")
            .with("database.port", "3306")
            .with("database.dbname", "test")
            .with("database.user", "root")
            .with("database.password", "password")
            .with("topic.prefix", "debezium_cdc_topic.test.user")
            .with("schema.history.internal.kafka.bootstrap.servers", "127.0.0.1:29092")
            .with("schema.history.internal.kafka.topic", "schema-changes.inventory")
            .with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
            .with("offset.storage.file.filename", "offset.dat")
            .with("table.include.list", "test.user")
//            .with("column.include.list", "storeDB.customer.*,storeDB.product.(id|price)")
            .build()
    }
}