package com.m.j.project.josephmay;

/**
 * Created by myadmin on 17/01/2017.
 */

public class DatabaseGetter {

    private int fTemp;
    private int fHumi;
    private boolean fStatus;
    private boolean status;

    public DatabaseGetter(){ // Default constructor

    }

    public DatabaseGetter (int temp, int humi, boolean status){
        fTemp = temp;
        fHumi = humi;
        fStatus = status;
    }

    public int getTemp(){
        return fTemp;
    }
    public void setTemp(int temp){
        fTemp = temp;
    }

    public int getHumi(){
        return fHumi;
    }
    public void setHumi(int humi){
        fHumi = humi;
    }

    public Boolean getStatus(){
        return fStatus;
    }

    public void setStatus(Boolean status){
        fStatus = status;
    }



}
