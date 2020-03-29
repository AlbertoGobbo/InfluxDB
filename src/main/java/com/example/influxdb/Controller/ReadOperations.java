package com.example.influxdb.Controller;

import com.example.influxdb.Model.AccessLogPoint;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

public class ReadOperations {

    private InfluxDB influxDB;
    private AccessLogPoint p;

    public ReadOperations(InfluxDB idb){
        this.influxDB = idb;
    }

    synchronized public void readPoint(){
        QueryResult queryResult = influxDB.query(new Query("SELECT * FROM " + p.nameMeasurement(), p.nameMeasurement()));

        System.out.println(queryResult);
    }

}