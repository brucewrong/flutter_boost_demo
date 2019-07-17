package com.flutterbus.fbdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.flutterbus.fbdemo.R;
import com.flutterbus.fbdemo.fluttermediator.PageRouter;
import com.flutterbus.fbdemo.utils.UrlUtil;
import com.taobao.idlefish.flutterboost.interfaces.IFlutterViewContainer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bruce on 2019-05-16
 */
public class SecondNativeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mDataTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.tv_content)).setText("这是第二个 Native Activity");
        mDataTv = findViewById(R.id.tv_data);
        findViewById(R.id.btn_flutter_first).setOnClickListener(this);
        findViewById(R.id.btn_flutter_second).setOnClickListener(this);

        Intent intent = getIntent();
        if(intent != null) {
            String url = intent.getStringExtra("url");
            Map map = UrlUtil.parseParams(url);
            if(map.containsKey("type")) {
                mDataTv.setText(map.get("type").toString());
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent();
            Map map = new HashMap();
            map.put("value", "flutter2020");
            intent.putExtra(IFlutterViewContainer.RESULT_KEY, (Serializable) map);
            setResult(RESULT_OK, intent);
            finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
