package com.flutterbus.fbdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.flutterbus.fbdemo.R;
import com.flutterbus.fbdemo.fluttermediator.PageRouter;
import com.flutterbus.fbdemo.utils.UrlUtil;

import java.util.Map;
import java.util.Set;

/**
 * Created by bruce on 2019-05-16
 */
public class FirstNativeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mDataTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.tv_content)).setText("这是第一个 Native Activity");
        mDataTv = findViewById(R.id.tv_data);
        findViewById(R.id.btn_flutter_first).setOnClickListener(this);
        findViewById(R.id.btn_flutter_second).setOnClickListener(this);

        Intent intent = getIntent();
        if(intent != null) {
            String url = intent.getStringExtra("url");
            Map map = UrlUtil.parseParams(url);
            if(map.containsKey("description")) {
                mDataTv.setText(map.get("description").toString());
            }
        }
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
