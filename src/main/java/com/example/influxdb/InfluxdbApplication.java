package com.example.influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBException;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Pong;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class InfluxdbApplication {

	public static void main(final String[] args) throws IOException {
		SpringApplication.run(InfluxdbApplication.class, args);

		final InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086");

		final Pong response = influxDB.ping();
		if (response.getVersion().equalsIgnoreCase("unknown")){
			influxDB.close();
			throw new InfluxDBException("Error pinging server.");
		} 
			
		if (influxDB.databaseExists("stalkerDB"))
			influxDB.setDatabase("stalkerDB");
		else{
			influxDB.close();
			throw new InfluxDBException("Database stalker-tsdb not found. Let's create into influx InfluxDB.");
		}
			
		/* Log the headers, body, and metadata for both requests and responses.
		   Note: This requires that the entire request and response body be buffered in memory! */	
		influxDB.setLogLevel(InfluxDB.LogLevel.FULL);

		AccessLogPoint p = new AccessLogPoint();

		influxDB.write(Point.measurement(p.nameMeasurement())
            .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
            .addField(p.nameAnonymousKey(), "dewefw")
            .addField(p.nameOrganizationId(), "moicnm")
            .addField(p.namePlaceId(), "iowen")
            .addField(p.nameInside(), false)
			.build());
			
		final QueryResult queryResult = influxDB.query(new Query("SELECT * FROM " + p.nameMeasurement(), p.nameMeasurement()));

		System.out.println(queryResult);

		/*WriteOperations wo = new WriteOperations(influxDB);
		ReadOperations ro = new ReadOperations(influxDB);

		wo.writePoint();
		ro.readPoint();*/
		
	}

}
