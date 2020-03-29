package com.example.influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBException;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Pong;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class InfluxdbApplication {

	public static void main(final String[] args) throws IOException, InfluxDBException {
		SpringApplication.run(InfluxdbApplication.class, args);

		final InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086");

		final Pong response = influxDB.ping();
		if (response.getVersion().equalsIgnoreCase("unknown")){
			influxDB.close();
			throw new InfluxDBException("Error pinging server.");
		} 
				
		if (influxDB.databaseExists("stalker-tsdb"))
			influxDB.setDatabase("stalker-tsdb");
		else{
			influxDB.close();
			throw new InfluxDBException("Database stalker-tsdb not found. Let's create into InfluxDB.");
		}
				
		/* Log the headers, body, and metadata for both requests and responses.
		Note: This requires that the entire request and response body be buffered in memory! */	
		influxDB.setLogLevel(InfluxDB.LogLevel.FULL);
		
	}

}
