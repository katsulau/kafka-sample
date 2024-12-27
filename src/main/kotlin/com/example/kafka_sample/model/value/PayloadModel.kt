package com.example.kafka_sample.model.value

import kotlinx.serialization.Serializable

@Serializable
data class PayloadModel(
    val before: String? = null,
    val after: String? = null,
    val source: Source? = null,
    val transaction: Transaction? = null,
    /**
     * c= 作成する
     * u= 更新
     * d= 削除
     * r= 読み取り (スナップショットにのみ適用)
     */
    val op: String? = null,
    val ts_ms: Long? = null,
    val ts_us: Long? = null,
    val ts_ns: Long? = null
)

@Serializable
data class Source(
    val version: String? = null,
    val connector: String? = null,
    val name: String? = null,
    val ts_ms: Long? = null,
    val snapshot: String? = null,
    val db: String? = null,
    val sequence: String? = null,
    val ts_us: Long? = null,
    val ts_ns: Long? = null,
    val table: String? = null,
    val server_id: Long? = null,
    val gtid: String? = null,
    val file: String? = null,
    val pos: Long? = null,
    val row: Int? = null,
    val thread: Long? = null,
    val query: String? = null
)

@Serializable
data class Transaction(
    val id: String? = null,
    val total_order: Long? = null,
    val data_collection_order: Long? = null
)