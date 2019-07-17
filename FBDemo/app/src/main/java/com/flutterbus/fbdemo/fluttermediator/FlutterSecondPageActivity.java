package com.flutterbus.fbdemo.fluttermediator;

import android.content.Intent;
import android.os.Bundle;

import com.flutterbus.fbdemo.utils.UrlUtil;
import com.taobao.idlefish.flutterboost.containers.BoostFlutterActivity;

import java.util.HashMap;
import java.util.Map;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

/**
 * Created by bruce on 2019-05-16
 */
public class FlutterSecondPageActivity extends BoostFlutterActivity {

    private int id;
    private String name;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if(intent != null) {
            String url = intent.getStringExtra("url");
            Map map = UrlUtil.parseParams(url);
            id = Integer.parseInt(map.get("id").toString());
            name = map.get("name").toString();
            address = map.get("address").toString();
        }
    }

    @Override
    public String getContainerName() {
        return PageRouter.FLUTTER_SECOND_PAGE_URL;
    }

    @Override
    public Map getContainerParams() {
        Map map = new HashMap();
        map.put("id", id);
        map.put("name", name);
        map.put("address", address);
        return map;
    }

    @Override
    public void onRegisterPlugins(PluginRegistry registry) {
        GeneratedPluginRegistrant.registerWith(registry);
    }
}
