package com.tfm.sensor.producer;

public interface IKafkaConstants {
    String KAFKA_BROKERS = "localhost:9092";
    Integer MESSAGE_COUNT=50000;
    String CLIENT_ID="client1";
    String TOPIC_NAME="sensor_input";
}