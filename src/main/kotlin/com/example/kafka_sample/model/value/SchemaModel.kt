package com.example.kafka_sample.model.value

import kotlinx.serialization.Serializable

@Serializable
data class SchemaModel(
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