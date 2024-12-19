//package com.example.kafka_sample.config
//
//import org.apache.kafka.clients.consumer.ConsumerConfig
//import org.apache.kafka.common.serialization.StringDeserializer
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.kafka.annotation.EnableKafka
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
//import org.springframework.kafka.core.ConsumerFactory
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory
//
//@Configuration
//@EnableKafka
//class KafkaConfig {
//
//    @Value("\${spring.kafka.consumer.bootstrap-servers}")
//    private lateinit var bootstrapServer: String
//
////    @Value("\${kafka.consumer-group-id}")
////    private lateinit var groupId: String
////
////    @Value("\${kafka.consumer-auto-offset-reset}")
////    private lateinit var autoOffsetReset: String
//
//    @Bean
//    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
//        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
//        factory.consumerFactory = consumerFactory()
//        factory.containerProperties.pollTimeout = 3000
//        return factory
//    }
//
//    @Bean
//    fun consumerFactory(): ConsumerFactory<String, String> {
//        val props = HashMap<String, Any>()
//        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
//        props[ConsumerConfig.GROUP_ID_CONFIG] = "sample-group"
//        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
//        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
//        return DefaultKafkaConsumerFactory(props)
//    }
//}