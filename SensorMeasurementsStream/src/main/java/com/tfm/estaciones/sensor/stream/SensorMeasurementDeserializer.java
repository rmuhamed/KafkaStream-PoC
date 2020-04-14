package com.tfm.estaciones.sensor.stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

public class SensorMeasurementDeserializer implements Deserializer<SensorMeasurement> {
    @Override
    public SensorMeasurement deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        SensorMeasurement object = null;
        try {
            object = mapper.readValue(data, SensorMeasurement.class);
        } catch (Exception exception) {
            System.out.println("Error in deserializing bytes "+ exception);
        }
        return object;
    }
}
