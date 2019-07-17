package com.flutterbus.fbdemo.fluttermediator;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.flutterbus.fbdemo.ui.MainActivity;
import com.taobao.idlefish.flutterboost.Debuger;
import com.taobao.idlefish.flutterboost.FlutterBoostPlugin;
import com.taobao.idlefish.flutterboost.interfaces.IPlatform;

import java.util.Map;

import io.flutter.view.FlutterMain;

/**
 * Created by bruce on 2019-05-16
 */
public class FlutterMeditor {
    public static void init(final Application app) {
        //此处必须启动初始化，主要是载入Flutter引擎文件
        FlutterMain.startInitialization(app);

        FlutterBoostPlugin.init(new IPlatform() {
            @Override
            public Application getApplication() {
                return app;
            }

            @Override
            public Activity getMainActivity() {
                return MainActivity.sRef.get();
            }

            @Override
            public boolean isDebug() {
                return true;
            }

            @Override
            public boolean startActivity(Context context, String url, int requestCode) {
                Debuger.log("startActivity url=" + url);

                return PageRouter.openPageByUrl(context, url, requestCode);
            }

            @Override
            public Map getSettings() {
                return null;
            }
        });
    }
}
