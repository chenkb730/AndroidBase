package com.hwm.test.view.pulltorefresh.recycler;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.base.BaseActivity;
import com.android.base.widget.pulltorefresh.PullToRefreshBase;
import com.android.base.widget.pulltorefresh.extras.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.android.base.widget.pulltorefresh.extras.recyclerview.PullToRefreshRecyclerView;
import com.hwm.test.R;
import com.hwm.test.view.pulltorefresh.JingDongHeaderLayout;
import com.hwm.test.view.pulltorefresh.recycler.adapter.DataAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2015/11/24 0024.
 */
public class PullToRefreshRecyclerActivity extends BaseActivity {

    @Bind(R.id.pull_refresh_recycler_view)
    PullToRefreshRecyclerView mRecyclerView;
    private List<String> mData = new ArrayList<>();
    DataAdapter mDataAdapter;
    HeaderAndFooterRecyclerViewAdapter adapter;

    RecyclerView recyclerView;

    @Override
    protected int getMainContentViewId() {
        return R.layout.act_pull_to_refresh_rcv;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setData();
        setBlock();
        setRecyclerView();
    }


    private void setData() {
        for (int i = 0; i < 25; i++) {
            mData.add("这是一条RecyclerView的数据" + (i + 1));
        }
    }

    private void setBlock() {
        getCommonBlockManager().add(new DataAdapter());
        mDataAdapter = getCommonBlockManager().get(DataAdapter.class);
    }

    private void setRecyclerView() {
        //设置刷新头部
        mRecyclerView.setHeaderLayout(new JingDongHeaderLayout(this, PullToRefreshBase.Mode.PULL_FROM_START));
        mRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        recyclerView = mRecyclerView.getRefreshableView();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        mDataAdapter.setDataAndAdapter(mData);
        adapter = new HeaderAndFooterRecyclerViewAdapter(mDataAdapter.mQuickRcvAdapter);
        recyclerView.setAdapter(adapter);


        mRecyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(final PullToRefreshBase<RecyclerView> refreshView) {
                mRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshView.onRefreshComplete();
                    }
                }, 500);
            }

            @Override
            public void onPullUpToRefresh(final PullToRefreshBase<RecyclerView> refreshView) {
                mRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int count = mDataAdapter.getAdapter().getItemCount();
                        for (int i = count; i < count + 15; i++) {
                            mData.add("这是一条RecyclerView的数据" + (i + 1));
                        }
                        adapter.notifyDataSetChanged();
                        refreshView.onRefreshComplete();
                        refreshView.getRefreshableView().smoothScrollToPosition(count + 1);
                    }
                }, 500);
            }
        });

    }

}
