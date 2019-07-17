package com.flutterbus.fbdemo.fluttermediator;

import android.os.Bundle;

import com.taobao.idlefish.flutterboost.containers.BoostFlutterActivity;

import java.util.Map;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

/**
 * Created by bruce on 2019-05-16
 */
public class FlutterThirdPageActivity extends BoostFlutterActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String getContainerName() {
        return PageRouter.FLUTTER_THIRD_PAGE_URL;
    }

    @Override
    public Map getContainerParams() {
        return null;
    }

    @Override
    public void onRegisterPlugins(PluginRegistry registry) {
        GeneratedPluginRegistrant.registerWith(registry);
    }
}
