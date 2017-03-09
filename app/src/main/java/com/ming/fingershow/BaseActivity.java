package com.ming.fingershow;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

import com.ming.fingersshow.utils.ViewUtils;

/**
 * Created by Administrator on 2017/3/9.
 */

public class BaseActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ViewUtils.addFingerlayout(this);
    }

}
