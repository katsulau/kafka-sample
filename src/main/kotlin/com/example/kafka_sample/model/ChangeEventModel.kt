package com.example.kafka_sample.model

import kotlinx.serialization.Serializable

@Serializable
data class ChangeEventModel(
    val schema: Schema? = null,
    val payload: Payload? = null
)

@Serializable
data class Schema(
    val type: String? = null,
    val fields: List<Field>? = null,
    val optional: Boolean? = null,
    val name: String? = null,
    val version: Int? = null
)

@Serializable
data class Field(
    val type: String? = null,
    val fields: List<SubField>? = null,
    val optional: Boolean? = null,
    val name: String? = null,
    val field: String? = null,
    val version: Int? = null,
    val default: String? = null,
    val parameters: Map<String, String>? = null
)

@Serializable
data class SubField(
    val type: String? = null,
    val optional: Boolean? = null,
    val field: String? = null,
    val name: String? = null,
    val version: Int? = null,
    val default: String? = null,
    val parameters: Map<String, String>? = null
)

@Serializable
data class Payload(
    val before: ValueData? = null,
    val after: ValueData? = null,
    val source: Source? = null,
    val transaction: Transaction? = null,
    val op: String? = null,
    val ts_ms: Long? = null,
    val ts_us: Long? = null,
    val ts_ns: Long? = null
)

@Serializable
data class ValueData(
    val id: Int? = null,
    val name: String? = null,
    val email: String? = null,
    val age: Int? = null,
    val created_at: String? = null
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