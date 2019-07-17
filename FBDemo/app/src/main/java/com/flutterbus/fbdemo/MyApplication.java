package com.flutterbus.fbdemo;

import android.app.Application;

import com.flutterbus.fbdemo.fluttermediator.FlutterMeditor;

/**
 * Created by bruce on 2019-05-16
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlutterMeditor.init(this);
    }
}
