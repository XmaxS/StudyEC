package com.example.latte_core.util.timer;

import java.util.TimerTask;

//用于倒计时，如启功app最开始的广告倒计时页面
public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener timerListener) {
        this.mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}
