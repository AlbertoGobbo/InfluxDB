package com.example.influxdb.Model;

public class Place{
    private int id;
    private int organization_id;
    private String name;
    private String position;

    public Place(int i, int o, String n, String p){
        this.id = i;
        this.organization_id = o;
        this.name = n;
        this.position = p;
    }

    public int getId(){
        return id;
    }

    public int getOrganizationId(){
        return organization_id;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }

    public void setId(int i){
        this.id = i;
    }

    public void setOrganizationId(int o){
        this.organization_id = o;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setPosition(String p){
        this.position = p;
    }

}