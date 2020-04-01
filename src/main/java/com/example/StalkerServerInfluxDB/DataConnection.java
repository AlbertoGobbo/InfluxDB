package com.example.StalkerServerInfluxDB;

public class DataConnection{

    private static final String URL = "http://localhost:8086";
    private static final String USER = "root";
    private static final String PASSWORD = "rootGruppOne";
    private static final String DATABASE = "stalkerDB";

    public String getURL(){
        return URL;
    }

    public String getUser(){
        return USER;
    }

    public String getPassword(){
        return PASSWORD;
    }

    public String getDatabase(){
        return DATABASE;
    }

}