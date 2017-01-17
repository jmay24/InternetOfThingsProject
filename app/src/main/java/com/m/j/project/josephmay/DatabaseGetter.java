package com.m.j.project.josephmay;

/**
 * Created by myadmin on 17/01/2017.
 */

public class DatabaseGetter {

    private String fTemp;
    private String fHumi;
    private boolean fStatus;

    public DatabaseGetter(){ // Default constructor

    }

    public DatabaseGetter (String temp, String humi, boolean status){
        fTemp = temp;
        fHumi = humi;
        fStatus = status;
    }

    public String getTemp(){
        return fTemp;
    }
    public void setTemp(String temp){
        fTemp = temp;
    }

    public String getHumi(){
        return fHumi;
    }
    public void setHumi(String humi){
        fHumi = humi;
    }

    public Boolean getStatus(){
        return fStatus;
    }

    public void setHStatus(Boolean status){
        fStatus = status;
    }



}
