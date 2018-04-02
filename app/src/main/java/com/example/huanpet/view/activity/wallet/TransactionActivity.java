package com.example.huanpet.view.activity.wallet;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;

import java.util.Calendar;
import java.util.Locale;

public class TransactionActivity extends BaseActivity {

    private TextView date;
    private TextView money;
    private TextView yue_zd;
    private LinearLayout bill;
    private RecyclerView rv_Transa;
    private int mYear;
    private int mMonth;
    private int mDay;
    private PopupWindow popupWindow;
    private LinearLayout line1;
    private TextView dsns;
    private TextView dsns1;

    @Override
    protected void initData() {

    }

    @Override
    protected void initview() {
        //返回按钮
        showBack(true);
        showTitle(true);
        setTitle("交易记录");
        showDetermine(true);
        setDetermine("筛选");
        showSouText(false);
        showMap(false);
        showUser(false);
        date = (TextView) findViewById(R.id.date);
        money = (TextView) findViewById(R.id.money);
        yue_zd = (TextView) findViewById(R.id.yue_zd);
        bill = (LinearLayout) findViewById(R.id.bill);
        yue_zd.setOnClickListener(this);
        bill.setOnClickListener(this);
        money.setOnClickListener(this);
        date.setOnClickListener(this);
        rv_Transa = (RecyclerView) findViewById(R.id.rv_Transa);
        line1 = findViewById(R.id.line1);
    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_transaction;
    }

    @Override
    protected void doDetermine() {

    /*    Log.e("-------------","sssssssssssssssssss");

        View inflate = LayoutInflater.from(TransactionActivity.this).inflate(R.layout.popupw_screening, null);
        popupWindow = new PopupWindow( 300,300);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAtLocation(line1, Gravity.CENTER, 0, 0);
        dsns = inflate.findViewById(R.id.dsns);
        dsns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });*/

   /* final View inflate = LayoutInflater.from(TransactionActivity.this).inflate(R.layout.popupw_screening, null);
    popupWindow = new PopupWindow(inflate, 300, 200);
    popupWindow.setFocusable(true);
    popupWindow.setBackgroundDrawable(new BitmapDrawable());
    popupWindow.showAtLocation(line1, Gravity.CENTER, 0, 0);
        dsns1 = findViewById(R.id.dsns);
       dsns1.setOnClickListener(this);
*/
    }

    @Override
    protected void intentUser() {
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.bill:

                break;
            case R.id.date:
                showDialog(0);
                break;
            case R.id.money:

                break;
            case R.id.dsns:
popupWindow.dismiss();
                break;
        }
    }

    protected Dialog onCreateDialog(int id) {
        Calendar dateAndTime = Calendar.getInstance(Locale.CHINA);
        mYear = dateAndTime.get(Calendar.YEAR);
        mMonth = dateAndTime.get(Calendar.MONTH);
        mDay = dateAndTime.get(Calendar.DAY_OF_MONTH);
        switch (id) {
            case 0:
                return new MonPickerDialog(this, mDateSetListener, mYear, mMonth,
                        mDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {



        public String dd;

        public int mDay;

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            int mYear = year;
            String mm;

            int mMonth;
            if (monthOfYear <= 9) {
                mMonth = monthOfYear + 1;
                mm = "0" + mMonth;
            } else {
                mMonth = monthOfYear + 1;
                mm = String.valueOf(mMonth);
            }
            if (dayOfMonth <= 9) {
                mDay = dayOfMonth;
                dd = "0" + mDay;
            } else {
                mDay = dayOfMonth;
                dd = String.valueOf(mDay);
            }
            mDay = dayOfMonth;


            date.setText(String.valueOf(mYear)+"年" + mm+"月");



        }
    };

    public class MonPickerDialog extends DatePickerDialog {
        @SuppressLint("NewApi")
        public MonPickerDialog(Context context, OnDateSetListener callBack,
                               int year, int monthOfYear, int dayOfMonth) {
            super(context, callBack, year, monthOfYear, dayOfMonth);
            this.setTitle(year + "年" + (monthOfYear + 1) + "月");


            ((ViewGroup) ((ViewGroup) this.getDatePicker().getChildAt(0))
                    .getChildAt(0)).getChildAt(2).setVisibility(View.GONE);

        }
        @Override
        public void onDateChanged(DatePicker view, int year, int month, int day) {
            super.onDateChanged(view, year, month, day);
            this.setTitle(year + "年" + (month + 1) + "月");
        }

    }



}