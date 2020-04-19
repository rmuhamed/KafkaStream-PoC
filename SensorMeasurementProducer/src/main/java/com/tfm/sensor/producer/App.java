package com.tfm.sensor.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

public class App {

    public static void main(String[] args) {
        runProducer();
    }

    static void runProducer() {
        Producer<Long, String> producer = ProducerCreator.createProducer();

        for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++) {
            try {
                String serializedMeasurement = SensorMeasurementCreator.create(index).serialize();
                ProducerRecord<Long, String> record = new ProducerRecord<>(IKafkaConstants.TOPIC_NAME, serializedMeasurement);
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("Record sent with key " + index + " with offset " + metadata.offset());
            } catch (ExecutionException | InterruptedException | JsonProcessingException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            }
        }
    }
}
