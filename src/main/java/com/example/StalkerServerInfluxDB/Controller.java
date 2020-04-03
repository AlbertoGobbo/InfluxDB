package com.example.StalkerServerInfluxDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.json.*;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
public class Controller{

    InfluxDBPoint point = new InfluxDBPoint();
    DataConnection connection = new DataConnection();

    @RequestMapping("/")
    public String index(){
        return "localhost:8080/ works well!";
    }

    @PostMapping("/location/update")
    @ResponseBody
    public String locationUpdate(@RequestBody Map<String, Object> body) {
        InfluxDB influxDB = InfluxDBFactory.connect(connection.getURL(),connection.getUser(),connection.getPassword());
        influxDB.setDatabase(connection.getDatabase());

        if(!body.get(point.namePlaceId()).getClass().isArray()){

            JSONObject jsonObject = new JSONObject(body);
            List<String> listPlaceData = new ArrayList<String>();
            JSONArray jArray = jsonObject.getJSONArray(point.namePlaceId());
            if (jArray != null) { 
                for (int i = 0; i < jArray.length(); i++)
                    listPlaceData.add(jArray.get(i).toString());
            }
            

            for(int i = 0; i < listPlaceData.size(); i++) {
                influxDB.write(Point.measurement(point.nameMeasurement())
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .addField(point.nameUserId(), Integer.parseInt(body.get(point.nameUserId()).toString()))
                .addField(point.nameAnonymous(), Boolean.parseBoolean((body.get(point.nameAnonymous()).toString())))
                .addField(point.namePlaceId(), Integer.parseInt(listPlaceData.get(i)))
                .addField(point.nameInside(), Boolean.parseBoolean(body.get(point.nameInside()).toString()))
                .build());
            } 
        }else{ //VA (da implementare controllo anonymousKey == NULL, allora influxDB.write diverso)
            influxDB.write(Point.measurement(point.nameMeasurement())
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .addField(point.nameUserId(), Integer.parseInt(body.get(point.nameUserId()).toString()))
                .addField(point.nameAnonymous(), Boolean.parseBoolean((body.get(point.nameAnonymous()).toString())))
                .addField(point.namePlaceId(), Integer.parseInt (body.get(point.namePlaceId()).toString()))
                .addField(point.nameInside(), Boolean.parseBoolean(body.get(point.nameInside()).toString()))
                .build()); //Questo va cxommentato perchè funziona a prescindere quello sopra
        }

        
            
        /* FUNZIONANTE 

        influxDB.write(Point.measurement(point.nameMeasurement())
        .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
        .addField(point.nameUserId(), Integer.parseInt(body.get(point.nameUserId())))
        //.addField(point.nameAnonymousKey(), body.get(point.nameAnonymousKey()))
        .addField(point.namePlaceId(), Integer.parseInt(body.get(point.namePlaceId())))
        .addField(point.nameInside(), Boolean.parseBoolean(body.get(point.nameInside())))
        .build()); */
            

        influxDB.close();
        
        return "Tracking inside ok";
    }


    /*
    @PostMapping("/tracking/inside")
    public StringQueryResult trackingInside(@RequestBody Map <String, String> body) {

       return "Tracking outside ok";
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
