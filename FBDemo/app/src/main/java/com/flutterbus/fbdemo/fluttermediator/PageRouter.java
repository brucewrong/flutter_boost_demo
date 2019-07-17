package com.flutterbus.fbdemo.fluttermediator;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.flutterbus.fbdemo.ui.FirstNativeActivity;
import com.flutterbus.fbdemo.ui.SecondNativeActivity;

/**
 * Created by bruce on 2019-05-16
 */
public class PageRouter {
    public static final String NATIVE_FIRST_PAGE_URL = "flutterbus://nativeFirstPage";
    public static final String NATIVE_SECOND_PAGE_URL = "flutterbus://nativeSecondPage";
    public static final String FLUTTER_FIRST_PAGE_URL = "flutterbus://flutterFirstPage";
    public static final String FLUTTER_SECOND_PAGE_URL = "flutterbus://flutterSecondPage";
    public static final String FLUTTER_THIRD_PAGE_URL = "flutterbus://flutterThirdPage";

    public static boolean openPageByUrl(Context context, String url) {
        return openPageByUrl(context, url, 0);
    }

    public static boolean openPageByUrl(Context context, String url, int requestCode) {
        try {
            Intent intent;
            if (url.startsWith(NATIVE_FIRST_PAGE_URL)) {
                intent = new Intent(context, FirstNativeActivity.class);
                intent.putExtra("url", url);
                context.startActivity(intent);
                return true;
            } else if (url.startsWith(NATIVE_SECOND_PAGE_URL)) {
                intent = new Intent(context, SecondNativeActivity.class);
                intent.putExtra("url", url);
                if(context instanceof Activity) {
                    ((Activity)context).startActivityForResult(intent, requestCode);
                }
                return true;
            } else if(url.startsWith(FLUTTER_FIRST_PAGE_URL)) {
                intent = new Intent(context, FlutterFirstPageActivity.class);
                intent.putExtra("url", url);
                context.startActivity(intent);
                return true;
            } else if (url.startsWith(FLUTTER_SECOND_PAGE_URL)) {
                intent = new Intent(context, FlutterSecondPageActivity.class);
                intent.putExtra("url", url);
                if(context instanceof Activity) {
                    ((Activity)context).startActivityForResult(intent, requestCode);
                }
                return true;
            } else if (url.startsWith(FLUTTER_THIRD_PAGE_URL)) {
                context.startActivity(new Intent(context, FlutterThirdPageActivity.class));
                return true;
            } else {
                return false;
            }
        } catch (Throwable t) {
            return false;
        }
    }

}
