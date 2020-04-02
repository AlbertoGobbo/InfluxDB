package com.example.StalkerServerInfluxDB;

import java.time.Instant;
import org.influxdb.annotation.*;

import jdk.jfr.Timestamp;

@Measurement(name = "access_log")
public class InfluxDBPoint{

    @Timestamp
    @Column(name = "time")
    private Instant time;
    
    @Column(name = "userId")
    private int userId;

    @Column(name = "anonymousKey")
    private int anonymousKey;

    @Column(name = "placeId")
    private int placeId;

    @Column(name = "inside")
    private boolean inside;

    //Methods useful to print field keys (with "" in addField)
    public String nameMeasurement(){
        return "accessLog";
    }

    public String nameUserId(){
        return "userId";
    }

    public String nameAnonymousKey(){
        return "anonymousKey";
    }

    public String namePlaceId(){
        return "placeId";
    }

    public String nameInside(){
        return "inside";
    }

    //Getter methods
    public Instant getTime(){
        return time;
    }

    public int getUserId(){
        return userId;
    }

    public int getAnonymousKey(){
        return anonymousKey;
    }

    public int getPlaceId(){
        return placeId;
    }

    public boolean getInside(){
        return inside;
    }

    //Setter methods
    public void setUserId(Integer s){
        this.userId=s;
    }

    public void setAnonymousKey(int s){
        this.anonymousKey=s;
    }

    public void setPlaceId(int s){
        this.placeId=s;
    }

    public void setInside(Boolean b){
        this.inside=b;
    }
    
}
