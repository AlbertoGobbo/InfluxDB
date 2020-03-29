package com.example.influxdb.Controller;

import com.example.influxdb.Model.AccessLogPoint;
import org.springframework.web.bind.annotation.*;

public class Operations{

    //to modify
    AccessLogPoint p = new AccessLogPoint();

    @PostMapping("/tracking/{userId}/{organizationId}/unknownIdentity")
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
    }

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
