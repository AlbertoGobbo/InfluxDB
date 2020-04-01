package com.example.StalkerServerInfluxDB;

import java.util.concurrent.TimeUnit;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class Controller{

    //InfluxDBPoint point = new InfluxDBPoint();
    DataConnection connection = new DataConnection();

    //@Autowired
    //InfluxDB influxDB;

    @RequestMapping("/")
    public String index(){
        return "localhost:8080/ works well!";
    }

    /* RequestBody: typically used with “create” and “update” operations (POST, PUT, PATCH). 
       Example: when creating a resource using POST or PUT, the request body usually contains the representation of the resource to be created.
       ResponseBody:  
    */

    @RequestMapping(value = "/tracking/inside", method = { RequestMethod.POST, RequestMethod.GET })
    //@PostMapping("/tracking/inside")
    @ResponseBody
    public String trackingInside(@RequestBody InfluxDBPoint point) {
        InfluxDB influxDB = InfluxDBFactory.connect(connection.getURL(),connection.getUser(),connection.getPassword());
        influxDB.setDatabase(connection.getDatabase());

        if(!influxDB.isGzipEnabled()) 
            influxDB.enableGzip();

        // understand how to differentiate queries between anonymous user and known user    
        influxDB.write(Point.measurement(point.nameMeasurement())
            .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
            .addField(point.nameUserId(), point.getUserId())
            .addField(point.nameAnonymousKey(), point.getAnonymousKey())
            .addField(point.nameOrganizationId(), point.getOrganizationId())
            .addField(point.namePlaceId(), point.getPlaceId())
            .addField(point.nameInside(), true)
            .build());    

        //influxDB.close();
        
        return "Tracking inside ok";
    }

    /*
    @PostMapping("/tracking/inside")
    public QueryResult trackingInside(@RequestBody Map <String, String> body) {

        influxDB.write(Point.measurement(point.nameMeasurement())
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
        .addField(point.nameUserId(), point.getUserId())
        .addField(point.nameOrganizationId(), point.getOrganizationId())
        .addField(point.namePlaceId(), point.getPlaceId())
        .addField(point.nameInside(), true)
        .build());

        QueryResult queryResult = influxDB.query(new Query("SELECT * FROM " + point.nameMeasurement() + " ORDER BY DESC LIMIT 1", "stalkerDB"));
        
        return queryResult;
    }*/
    
    /*@PostMapping("/tracking/outside")
    public SomeEnityData trackingOutside(@RequestBody SomeEnityData entity) {
        
        return entity;
    }*/


    /*@PostMapping("/tracking/{userId}/{organizationId}/unknownIdentity")
    public AccessLogPoint anonymousTrackingUser(){
        return p;
    }

    @PostMapping("tracking/{userId}/{organizationId}/knownIdentity")
    public AccessLogPoint knownTrackingUser(){
        return p;
    }

    @PostMapping("/tracking/organization/place")
    public AccessLogPoint addUserInPlace(){
        return p;
    }

    @DeleteMapping("/tracking/organization/place")
    public AccessLogPoint exitUserInPlace(){
        return p;
    }*/

	/*influxDB.write(Point.measurement(p.nameMeasurement())
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
        .addField(p.nameAnonymousKey(), "dewefw")
        .addField(p.nameOrganizationId(), "moicnm")
        .addField(p.namePlaceId(), "iowen")
        .addField(p.nameInside(), false)
		.build());
			
	final QueryResult queryResult = influxDB.query(new Query("SELECT * FROM " + p.nameMeasurement(), p.nameMeasurement()));

	System.out.println(queryResult);*/

}
