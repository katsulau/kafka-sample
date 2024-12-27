package com.example.kafka_sample.config

import io.debezium.config.Configuration
import org.springframework.context.annotation.Bean


@org.springframework.context.annotation.Configuration
class DebeziumConfig {

    // https://debezium.io/documentation/reference/stable/connectors/mysql.html#mysql-deploying-a-connector
    // https://debezium.io/documentation/reference/stable/development/engine.html#_in_the_code
    @Bean
    fun debeziumFactory(): Configuration {
        return Configuration.create()
            .with("name", "engine")
            .with("connector.class", "io.debezium.connector.mysql.MySqlConnector")
            // 良さそうな保存場所を考える APIで動的に任意の地点に切り替えれないか
            .with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
            .with("offset.storage.file.filename", "offset.dat")
            .with("offset.flush.interval.ms", "60000")
            .with("database.hostname", "127.0.0.1")
            .with("database.port", "3306")
            // テスト待ち
//            .with("database.dbname", "test,USER_MANAGEMENT,product-inventory,OrderManagement")
            .with("database.user", "root")
            .with("database.password", "password")
            // 一意であればどんな値でも良さそう
            .with("database.server.id", "1")
            .with("topic.prefix", "debezium_app_cdc_topic")
            .with("schema.history.internal", "io.debezium.storage.file.history.FileSchemaHistory")
            .with("schema.history.internal.file.filename", "schemahistory.dat")
            // テスト待ち
//            .with("table.include.list", "test.user, USER_MANAGEMENT.Users, product-inventory.Products-, OrderManagement.OrderItems")
//            .with("column.include.list", "USER_MANAGEMENT.Users.(01NAME|\$Email)")
            .with("include.schema.changes", "false")
//            .with("transforms", "filter")
//            .with("transforms.filter.type", "io.debezium.transforms.Filter")
//            .with("transforms.filter.language", "jsr223.groovy")
//            .with("transforms.filter.condition", "value.op == c")
//        　　　DDL,DMLの変更が{}で囲まれたJSON形式で送信される
//            .with("converter.schemas.enable", "false")
            .build()
    }
}