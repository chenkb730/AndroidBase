package com.hwm.test.view.banner;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import com.android.base.BaseActivity;
import com.hwm.test.R;
import com.hwm.test.view.banner.block.BannerBlock;

/**
 * Created by Administrator on 2015/11/20 0020.
 */
public class BannerActivity extends BaseActivity {


    @Override
    protected int getMainContentViewId() {
        return R.layout.act_banner_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCommonBlockManager().add(new BannerBlock());
        setToolBar();
    }


    private void setToolBar() {
        getSupportActionBar().setTitle("Banner Test");
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
