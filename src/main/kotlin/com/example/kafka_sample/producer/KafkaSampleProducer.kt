package com.example.kafka_sample.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaSampleProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    fun sendStringMessage(message: String) {
        kafkaTemplate.send("kafka-sample", message)
    }
}