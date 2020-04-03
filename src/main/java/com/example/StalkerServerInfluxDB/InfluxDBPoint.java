package com.example.StalkerServerInfluxDB;

import java.time.Instant;
import org.influxdb.annotation.*;
import jdk.jfr.Timestamp;

@Measurement(name = "accessLog")
public class InfluxDBPoint{

    @Timestamp
    @Column(name = "time")
    private Instant time;

    @Column(name = "timestampMs")
    private java.sql.Timestamp timestampMs;
    
    @Column(name = "userId")
    private int userId;

    //@Column(name = "anonymous") dopo POC
    //private String anonymous;

    @Column(name = "anonymous")
    private boolean anonymous;

    @Column(name = "placeId")
    private int placeId;

    @Column(name = "inside")
    private boolean inside;

    //Methods useful to print field keys (with "" in addField)
    public String nameMeasurement(){
        return "accessLog";
    }

    public String nameTimestampMs(){
        return "timestampMs";
    }

    public String nameUserId(){
        return "userId";
    }

    /*public String nameAnonymousKey(){
        return "anonymousKey";
    }*/

    public String nameAnonymous(){
        return "anonymous";
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

    public java.sql.Timestamp getTimestampMs(){
        return timestampMs;
    }

    public int getUserId(){
        return userId;
    }

    /*public int getAnonymousKey(){
        return anonymousKey;
    }*/

    public boolean getAnonymous(){
        return anonymous;
    }

    public int getPlaceId(){
        return placeId;
    }

    public boolean getInside(){
        return inside;
    }

    //Setter methods
    public void setUserId(int s){
        this.userId = s;
    }

    /*public void setAnonymousKey(int s){
        this.anonymousKey=s;
    }*/

    public void setAnonymous(boolean b){
        this.anonymous = b;
    }

    public void setPlaceId(int s){
        this.placeId = s;
    }

    public void setInside(boolean b){
        this.inside = b;
    }
    
}
