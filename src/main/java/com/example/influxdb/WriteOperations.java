package com.example.influxdb;

import java.util.concurrent.TimeUnit;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;

public class WriteOperations {

    private InfluxDB influxDB;
    private AccessLogPoint p;

    public WriteOperations(InfluxDB idb){
        this.influxDB = idb;
    }

    synchronized public void writePoint(){
        influxDB.write(Point.measurement(p.nameMeasurement())
            .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
            .addField(p.nameAnonymousKey(),"dewefw")
            .addField(p.nameOrganizationId(), "moicnm")
            .addField(p.namePlaceId(), "iowen")
            .addField(p.nameInside(), false)
            .build());
    }

}