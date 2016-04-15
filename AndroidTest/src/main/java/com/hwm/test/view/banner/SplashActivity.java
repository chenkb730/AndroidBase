package com.hwm.test.view.banner;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.android.base.BaseActivity;
import com.hwm.test.R;
import com.hwm.test.view.banner.block.SplashBlock;

/**
 * Created by Administrator on 2015/11/22 0022.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected int getMainContentViewId() {
        return R.layout.act_splash_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCommonBlockManager().add(new SplashBlock());

    }

   
}
