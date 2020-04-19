package com.tfm.sensor.consumer;

public interface IKafkaConstants {
    String KAFKA_BROKERS = "localhost:9092";
    String TOPIC_NAME="sensor_output";
    String GROUP_ID_CONFIG="consumerGroup1";
    Integer MAX_NO_MESSAGE_FOUND_COUNT=100;
    String OFFSET_RESET_EARLIER="earliest";
    Integer MAX_POLL_RECORDS=1;
}