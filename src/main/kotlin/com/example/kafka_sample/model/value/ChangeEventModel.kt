package com.example.kafka_sample.model.value

import kotlinx.serialization.Serializable

@Serializable
data class ChangeEventModel(
    /**
     * before状態のテーブルのpayloadに含まれる型情報
     * after状態のテーブルのpayloadに含まれる型情報
     * io.debezium.connector.mysql.Sourceの情報
     * debezium_app_cdc_topic.test.profile.Envelopeの設定情報
     *
     * memo: テーブル構造が変わらないことが保証されるのであれば、before, afterは不要かもしれない
     */
    val schema: SchemaModel? = null,
    val payload: PayloadModel? = null
)

