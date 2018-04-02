package com.example.huanpet.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lmf on 2016/5/20.
 */
public class MyCountDownTimer extends CountDownTimer {
	private TextView mBtn;

	// 总共的倒计时时间 2 倒计时的间隔时间 3、倒计时的作用控件
	public MyCountDownTimer(long millisInFuture, long countDownInterval,
                            TextView btn) {
		super(millisInFuture, countDownInterval);
		this.mBtn = btn;
	}

	// 每隔一秒执行一次这个方法 总共的倒计时时间
	@Override
	public void onTick(long time) {
		mBtn.setEnabled(false);
		mBtn.setText(time / 1000 + "秒后可重新发送");
		mBtn.setTextSize(20);
		Spannable span = new SpannableString(mBtn.getText().toString().trim());
		// 1.文本的样式
		ForegroundColorSpan textColor = new ForegroundColorSpan(
				Color.parseColor("#FF0000"));
		// 2.文本开始的索引值
		// 3.文本结束的索引值
		// 4.常量标记
		span.setSpan(textColor, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		mBtn.setText(span);
	}

	// 倒计时完成的时候调用
	@Override
	public void onFinish() {
		mBtn.setEnabled(true);
		mBtn.setTextSize(15);
		mBtn.setText("重新获取验证码");
	}

}
