package com.ming.fingershow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/3/9.
 */

public class ThirdActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_to_next_page;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initView();
    }

    private void initView() {
        btn_to_next_page = (Button) findViewById(R.id.btn_to_next_page);
        btn_to_next_page.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_to_next_page:
                finish();
                break;
        }
    }
}
