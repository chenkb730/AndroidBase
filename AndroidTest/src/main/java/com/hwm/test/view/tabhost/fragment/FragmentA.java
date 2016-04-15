package com.hwm.test.view.tabhost.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.base.BaseFragment;
import com.android.base.widget.PagerSlidingTabStrip;
import com.hwm.test.R;
import com.hwm.test.view.tabhost.fragment.adapter.MyPagerAdapter;

import butterknife.Bind;

/**
 * Created by Administrator on 2015/8/3 0003.
 */
public class FragmentA extends BaseFragment {


    @Bind(R.id.tabs)
    PagerSlidingTabStrip mTabs;
    @Bind(R.id.pager)
    ViewPager mViewPager;
    private DisplayMetrics mDm;

    @Override
    protected int getMainContentViewId() {
        return R.layout.frag_test_a;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTabs();
        setTabs();
    }


    private void initTabs() {
        mViewPager.setAdapter(new MyPagerAdapter(this.getChildFragmentManager()));
        mTabs.setViewPager(mViewPager);
    }

    private void setTabs() {

        mDm = getResources().getDisplayMetrics();

        // 设置Tab是自动填充满屏幕的
        mTabs.setShouldExpand(true);
        // 设置Tab的分割线是透明的
        mTabs.setDividerColor(Color.TRANSPARENT);
        // 设置Tab底部线的高度
        mTabs.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, mDm));
        // 设置Tab Indicator的高度
        mTabs.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4, mDm));
        // 设置Tab标题文字的大小
        mTabs.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, mDm));
        // 设置Tab Indicator的颜色
        mTabs.setIndicatorColor(Color.parseColor("#45c01a"));
        // 设置选中Tab文字的颜色 (这是我自定义的一个方法)
        mTabs.setSelectedTextColor(Color.parseColor("#45c01a"));
        // 取消点击Tab时的背景色
        mTabs.setTabBackground(0);
    }


}
