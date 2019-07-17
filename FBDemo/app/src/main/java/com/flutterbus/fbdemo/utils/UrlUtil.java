package com.flutterbus.fbdemo.utils;

import android.net.Uri;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by bruce on 2019-05-16
 */
public class UrlUtil {

    public static Map parseParams(String url) {
        Uri uri = Uri.parse(url);
        Set<String> paramKeySet = uri.getQueryParameterNames();
        if(paramKeySet == null || paramKeySet.isEmpty()) {
            return null;
        }

        Map map = new HashMap();
        Iterator<String> it = paramKeySet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            map.put(key, uri.getQueryParameter(key));
        }

        return map;
    }

    public static String parseName(String url) {
        Uri uri = Uri.parse(url);
        return uri.getHost();
    }
}
