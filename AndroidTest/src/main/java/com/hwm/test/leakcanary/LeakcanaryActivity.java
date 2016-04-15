package com.hwm.test.leakcanary;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.android.base.BaseActivity;
import com.hwm.test.R;

import butterknife.OnClick;

/**
 * Created by Administrator on 2015/11/17 0017.
 */
public class LeakcanaryActivity extends BaseActivity {

    private Object[] mObjs = new Object[10000];//快速消耗内存

    @Override
    protected int getMainContentViewId() {
        return R.layout.act_leakcanary_main;
    }


    @OnClick(R.id.async_task)
    void startAsync() {
        for (int i = 0; i < mObjs.length; i++) {
            mObjs[i] = new Object();
        }

        /**
         * 设置为横屏
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }


}
