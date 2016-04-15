package com.hwm.test.net;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.base.BaseActivity;
import com.android.base.common.assist.Toastor;
import com.android.base.netstate.NetWorkUtil;
import com.hwm.test.AppConfig;
import com.hwm.test.R;

import butterknife.Bind;

/**
 * Created by Administrator on 2015/10/9 0009.
 */
public class TestHttpActivity extends BaseActivity {

    @Bind(R.id.tv1)
    TextView mTv1;
    @Bind(R.id.tv2)
    TextView mTv2;
    @Bind(R.id.tv3)
    TextView mTv3;
    @Bind(R.id.tv4)
    TextView mTv4;

    @Override
    protected int getMainContentViewId() {
        return R.layout.act_test_http;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private void setToolBar() {
        getSupportActionBar().setTitle("OKhttp封装测试");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

   
    @Override
    public void onConnect(NetWorkUtil.netType type) {
        super.onConnect(type);
        Toastor.showToast(mApplicationContext, "网络已经连接");
    }

    @Override
    public void onDisConnect() {
        super.onDisConnect();
        Toastor.showToast(mApplicationContext, "网络已经断开");
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what) {
            case AppConfig.REQUEST_GET_FAIL://失败
                mTv1.setText("获取失败");
                break;
            case AppConfig.REQUEST_GET_SUCCESS://成功
                mTv1.setText((String) msg.obj);
                break;
            case AppConfig.REQUEST_POST_FAIL://失败
                mTv2.setText("获取失败");
                break;
            case AppConfig.REQUEST_POST_SUCCESS://成功
                mTv2.setText((String) msg.obj);
                break;
            case AppConfig.REQUEST_POST_FAIL_FOR_BEAN://失败
                mTv3.setText("获取失败");
                break;
            case AppConfig.REQUEST_POST_SUCCESS_FOR_BEAN://成功
                TestBean mTestBeanPost = (TestBean) msg.obj;
                mTv3.setText(mTestBeanPost.getGeye().getPuName());
                break;
            case AppConfig.REQUEST_GET_FAIL_FOR_BEAN://失败
                mTv4.setText("获取失败");
                break;
            case AppConfig.REQUEST_GET_SUCCESS_FOR_BEAN://成功
                TestBean mTestBeanGet = (TestBean) msg.obj;
                mTv4.setText(mTestBeanGet.getGeye().getRtspAddr());
                break;
            default:
                break;
        }
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
