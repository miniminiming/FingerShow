package com.ming.fingershow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_to_next_page;
    private RelativeLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        btn_to_next_page = (Button) findViewById(R.id.btn_to_next_page);
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);

        btn_to_next_page.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_to_next_page:
                startActivity(new Intent(this, SecondActivity.class));
                break;
        }
    }
}
