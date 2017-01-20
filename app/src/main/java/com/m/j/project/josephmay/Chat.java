package com.m.j.project.josephmay;

/**
 * Created by Joseph on 17/01/2017.
 */

public class Chat {
    private Float mHumi;
    private Float mTemp;

    public Chat() {
        // Needed for Firebase
    }


    public Chat(float Humi, float Temp) {
        mHumi = Humi;
        mTemp = Temp;
    }


    public float  getHumi(){ return mHumi; }

    public void setHumi (float Humi) { mHumi = Humi; }

    public float  getTemp(){ return mTemp; }

    public void setTemp (float Temp) { mTemp = Temp; }

}