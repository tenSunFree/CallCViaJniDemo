package com.home.callcviajnidemo.jni;

public class ShowLuckyNumberJni {

    static {
        System.loadLibrary("ShowLuckyNumberJniLibrary");
    }

    public native String getTitle();

    public native int getLuckyNumber(int number);
}
