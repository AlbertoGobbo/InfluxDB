package com.example.influxdb.Model;

import java.time.Instant;

public class Organization{
    private int id;
    private String name;
    private String description;
    private String ldap_conf;
    private Instant created_date;
    private Instant last_modified_date;
    
    public Organization(int i, String n, String d, String l, Instant t){
        this.id = i;
        this.name = n;
        this.description = d;
        this.ldap_conf = l;
        this.created_date = t;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getLdap(){
        return ldap_conf;
    }

    public Instant getCreatedDate(){
        return created_date;
    }

    public Instant getLastModifiedDate(){
        return last_modified_date;
    }

    public void setId(int i){
        this.id = i;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setDescription(String d){
        this.description = d;
    }

    public void setLdap(String l){
        this.ldap_conf = l;
    }

    public void setCreatedDate(Instant t){
        this.created_date = t;
    }

    public void setLastModifiedDate(Instant t){
        this.last_modified_date = t;
    }

}