package com.example.influxdb.Model;

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

    //Methods useful to print field keys (with "" in addField)
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

    //Getter methods
    public Instant getTime(){
        return time;
    }

    public String getUserId(){
        return user_id;
    }

    public String getAnonymousKey(){
        return anonymous_key;
    }

    public String getOrganizationId(){
        return organization_id;
    }

    public String getPlaceId(){
        return place_id;
    }

    public boolean getInside(){
        return inside;
    }

    //Setter methods
    public void setUserId(String s){
        this.user_id=s;
    }

    public void setAnonymousKey(String s){
        this.anonymous_key=s;
    }

    public void setOrganizationId(String s){
        this.organization_id=s;
    }

    public void setPlaceId(String s){
        this.place_id=s;
    }

    public void setInside(Boolean b){
        this.inside=b;
    }
    
}
