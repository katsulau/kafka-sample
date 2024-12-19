package com.example.kafka_sample.consumer

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaSampleConsumer {
    @KafkaListener(topics = ["kafka-sample", "debezium_cdc_topic.test.user"], groupId = "sample-group")
    fun firstListener(message: String) {
        println("Message received: [$message]")
    }
}