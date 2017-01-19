package com.m.j.project.josephmay;

/**
 * Created by Joseph on 17/01/2017.
 */

public class Chat {
    private String mName;
    private String mMessage;
    private String mUid;
    private Float mHumi;
    private Float mTemp;

    public Chat() {
        // Needed for Firebase
    }

  /*  public Chat(String name, String message, String uid, float Humi, float Temp) {
        mName = name;
        mMessage = message;
        mUid = uid;
        mHumi = Humi;
        mTemp = Temp;
    }*/

    public Chat(float Humi, float Temp) {
        mHumi = Humi;
        mTemp = Temp;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public float  getHumi(){ return mHumi; }

    public void setHumi (float Humi) { mHumi = Humi; }

    public float  getTemp(){ return mTemp; }

    public void setTemp (float Temp) { mTemp = Temp; }

    public String getUid() {
        return mUid;
    }

    public void setUid(String uid) {
        mUid = uid;
    }
}