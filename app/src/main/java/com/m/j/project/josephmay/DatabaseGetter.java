package com.m.j.project.josephmay;

/**
 * Created by myadmin on 17/01/2017.
 */

public class DatabaseGetter {

    private int fTemp;
    private int fHumi;
    private boolean fStatus;
    private int fVibe;

    public DatabaseGetter(){ // Default constructor

    }

    public DatabaseGetter (int temp, int humi, int vibe, boolean status){
        fTemp = temp;
        fHumi = humi;
        fVibe = vibe;
        fStatus = status;

    }

    public int getTemp(){
        return fTemp;
    }
    public void setTemp(int temp){
        fTemp = temp;
    }

    public int getVibe(){
        return fVibe;
    }
    public void setVibe(int vibration ){
        fVibe = vibration;
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
