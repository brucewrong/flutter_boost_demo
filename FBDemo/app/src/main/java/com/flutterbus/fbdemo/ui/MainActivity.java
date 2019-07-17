package com.flutterbus.fbdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flutterbus.fbdemo.R;
import com.flutterbus.fbdemo.fluttermediator.PageRouter;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static WeakReference<MainActivity> sRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sRef = new WeakReference<>(this);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_flutter_first).setOnClickListener(this);
        findViewById(R.id.btn_flutter_second).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_flutter_first:
                PageRouter.openPageByUrl(this, PageRouter.FLUTTER_FIRST_PAGE_URL+"?id=123&name=bruce");
                break;
            case R.id.btn_flutter_second:
                PageRouter.openPageByUrl(this, PageRouter.FLUTTER_SECOND_PAGE_URL+"?id=333&name=desire&address=hangzhou");
                break;
        }
    }
}
