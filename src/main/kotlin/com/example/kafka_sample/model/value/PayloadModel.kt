package com.example.kafka_sample.model.value

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNames

@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class PayloadModel(
    val before: JsonElement? = null,
    val after: JsonElement? = null,
    val source: Source? = null,
    val transaction: Transaction? = null,
    @JsonNames("op")
    val operation: Operation,
    val ts_ms: Long? = null,
    val ts_us: Long? = null,
    val ts_ns: Long? = null
)

@Serializable
data class Source(
    val db: String,
    val table: String,
    val version: String? = null,
    val connector: String? = null,
    val name: String? = null,
    val ts_ms: Long? = null,
    val snapshot: String? = null,
    val sequence: String? = null,
    val ts_us: Long? = null,
    val ts_ns: Long? = null,
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