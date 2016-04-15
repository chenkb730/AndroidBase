package com.hwm.test.view.tabhost.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.base.BaseFragment;
import com.hwm.test.R;

import butterknife.Bind;

/**
 * Created by Administrator on 2015/8/3 0003.
 */
public class FragmentD extends BaseFragment {

    @Bind(R.id.tv)
    TextView mTv;

    @Override
    protected int getMainContentViewId() {
        return R.layout.frag_test;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTv.setText("我是第四页");
    }


}
