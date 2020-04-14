package com.tfm.sensor.producer;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class SensorMeasurementCreator {

    static SensorMeasurement create(Integer regionId) {
        SensorMeasurement sensorMeasurement = new SensorMeasurement();

        Integer temp = ThreadLocalRandom.current().nextInt(0, 50);

        sensorMeasurement.setRegionId("R"+regionId);
        sensorMeasurement.setName("S"+regionId+sensorMeasurement.getRegionId());
        sensorMeasurement.setTemperature(temp);
        sensorMeasurement.setTimestamp(LocalDateTime.now().toString());
        sensorMeasurement.setUnit(TemperatureUnit.CELSIUS);

        return sensorMeasurement;
    }
}
