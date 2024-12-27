package com.example.kafka_sample.model.value

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Operation {
    @SerialName("c")
    CREATE,
    @SerialName("u")
    UPDATE,
    @SerialName("d")
    DELETE,
    // スナップショット時のみ
    @SerialName("r")
    READ
}