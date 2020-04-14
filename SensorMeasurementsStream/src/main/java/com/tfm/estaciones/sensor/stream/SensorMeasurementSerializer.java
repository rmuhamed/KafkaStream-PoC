package com.tfm.estaciones.sensor.stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class SensorMeasurementSerializer implements Serializer<SensorMeasurement> {

    @Override
    public byte[] serialize(String topic, SensorMeasurement data) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception exception) {
            System.out.println("Error in serializing object"+ data);
        }
        return retVal;
    }
}
