package com.example.huanpet.view.activity.wallet;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;

public class WalletActivity extends BaseActivity implements View.OnClickListener {

    private TextView jg_name;
    private Button recharge;
    private Button withdraw;
    private LinearLayout Alipay;
    private LinearLayout jf;
    private LinearLayout yhq;



    @Override
    protected void initData() {

    }

    @Override
    protected void initview() {
        //返回按钮
        showBack(true);
        showTitle(true);
        setTitle("我的钱包");
        showDetermine(true);
        setDetermine("消费记录");
        showSouText(false);
        showMap(false);
        showUser(false);

        initView();
    }
    @Override
    public int getlayoutID() {
        return R.layout.activity_wallet;
    }

    private void initView() {
        jg_name = (TextView) findViewById(R.id.jg_name);
        recharge = (Button) findViewById(R.id.recharge);
        withdraw = (Button) findViewById(R.id.withdraw);
        Alipay = (LinearLayout) findViewById(R.id.Alipay);
        jf = (LinearLayout) findViewById(R.id.jf);
        yhq = (LinearLayout) findViewById(R.id.yhq);

        recharge.setOnClickListener(this);
        withdraw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.recharge:

                break;
            case R.id.withdraw:

                break;
        }
    }

    @Override
    protected void doDetermine() {
        Intent intent = new Intent(WalletActivity.this,TransactionActivity.class);
        startActivity(intent);
    }

    @Override
    protected void intentUser() {

    }
}
