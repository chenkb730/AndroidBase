package com.hwm.test.view.other;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;

import com.android.base.BaseActivity;
import com.android.base.widget.SideLayout;
import com.hwm.test.R;

import butterknife.Bind;

/**
 * Created by Administrator on 2015/11/27 0027.
 */
public class SideLayoutActivity extends BaseActivity {
    @Bind(R.id.toggle)
    Button mToggle;
    @Bind(R.id.side_layout)
    SideLayout mSideLayout;

    @Override
    protected int getMainContentViewId() {
        return R.layout.act_side_layout;
    }


    //@OnClick(R.id.toggle)
    void onClick() {
        mSideLayout.toggle();
    }


}
