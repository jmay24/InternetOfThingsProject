package com.m.j.project.josephmay;

public class Chat {
    private String mHumi;
    private String  mTemp;

    public Chat() {
        // Needed for Firebase
    }


    public Chat(String humi, String temp) {
        mHumi = humi;
        mTemp = temp;
    }


    public String  getHumi(){ return mHumi; }

    public void setHumi (String humi) { this.mHumi = humi; }

    public String  getTemp(){ return mTemp; }

    public void setTemp (String temp) { this.mTemp = temp; }

}