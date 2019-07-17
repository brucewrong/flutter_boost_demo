package com.flutterbus.fbdemo.fluttermediator;

import android.content.Intent;
import android.os.Bundle;

import com.flutterbus.fbdemo.utils.UrlUtil;
import com.taobao.idlefish.flutterboost.containers.BoostFlutterActivity;

import java.util.Map;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

/**
 * Created by bruce on 2019-05-16
 */
public class FlutterPageActivity extends BoostFlutterActivity {

    String name = null;
    Map map = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        map = UrlUtil.parseParams(url);
        name = map.get("pageName").toString();
    }

    @Override
    public String getContainerName() {
        return name;
    }

    @Override
    public Map getContainerParams() {
        return map;
    }

    @Override
    public void onRegisterPlugins(PluginRegistry registry) {
        GeneratedPluginRegistrant.registerWith(registry);
    }
}
