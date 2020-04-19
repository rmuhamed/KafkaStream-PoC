package com.tfm.sensor.producer;

import java.util.concurrent.ThreadLocalRandom;

public class SensorMeasurementCreator {

    static SensorMeasurement create(Integer sensorId) {
        SensorMeasurement sensorMeasurement = new SensorMeasurement();

        Integer temp = ThreadLocalRandom.current().nextInt(0, 40);

        sensorMeasurement.setTemperatureUnit("CELSIUS");
        sensorMeasurement.setSensorName("Sensor"+sensorId);
        sensorMeasurement.setSensorId(sensorId);
        sensorMeasurement.setTemperature(temp);

        Metadata metadata = new Metadata();
        metadata.setGatewayId(1);
        metadata.setRegionName("El valles occidental");
        metadata.setTimestamp(Long.valueOf(System.currentTimeMillis()).intValue());

        sensorMeasurement.setMetadata(metadata);

        return sensorMeasurement;
    }
}
