package com.ming.fingershow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.ming.fingersshow.utils.ViewUtils;

/**
 * Created by Administrator on 2017/3/9.
 */

public class SecondActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_to_next_page;
    private Button btn_close;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        //不显示特效只需要调用这个就行了
        ViewUtils.requestNoFingerShow(this);
    }

    private void initView() {
        btn_to_next_page = (Button) findViewById(R.id.btn_to_next_page);
        btn_to_next_page.setOnClickListener(this);
        btn_close = (Button) findViewById(R.id.btn_close);
        btn_close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_to_next_page:
                startActivity(new Intent(this, ThirdActivity.class));
                break;
            case R.id.btn_close:
                finish();
                break;
        }
    }
}
