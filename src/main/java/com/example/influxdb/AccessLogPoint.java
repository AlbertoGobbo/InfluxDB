package com.example.influxdb;

import java.time.Instant;
import org.influxdb.annotation.*;

@Measurement(name = "access_log")
public class AccessLogPoint{

    @Column(name = "time")
    private Instant time;
    
    @Column(name = "user_id")
    private String user_id;

    @Column(name = "anonymous_key")
    private String anonymous_key;

    @Column(name = "organization_id")
    private String organization_id;

    @Column(name = "place_id")
    private String place_id;

    @Column(name = "inside")
    private boolean inside;

    public String nameMeasurement(){
        return "access_log";
    }

    public String nameUserId(){
        return "user_id";
    }

    public String nameAnonymousKey(){
        return "anonymous_key";
    }

    public String nameOrganizationId(){
        return "organization_id";
    }

    public String namePlaceId(){
        return "place_id";
    }

    public String nameInside(){
        return "inside";
    }
    
}
