package com.hwm.test.view.autolayout;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import com.android.base.BaseActivity;
import com.hwm.test.R;

/**
 * Created by Administrator on 2015/11/25 0025.
 */
public class AutoLayoutActivity extends BaseActivity {
    @Override
    protected int getMainContentViewId() {
        return R.layout.act_auto_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBar();
    }


    private void setToolBar() {
        getSupportActionBar().setTitle("测试多层嵌套的AutoLayout适配-1");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
