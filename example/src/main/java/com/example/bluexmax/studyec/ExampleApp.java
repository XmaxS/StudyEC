package com.example.bluexmax.studyec;

import android.app.Application;
import com.example.bluexmax.studyec.event.ShareEvent;
import com.example.bluexmax.studyec.event.TestEvent;
import com.example.latte.ec.database.DatabaseManager;
import com.example.latte.ec.icon.FontEcModule;
import com.example.latte_core.app.Latte;
import com.example.latte_core.net.interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;


public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        标准初始化模式
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://127.0.0.1")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
//                .withWeChatAppId("")
//                .withWeChatAppSecret("")
                .withJavascriptInterface("latte")
                .withWebEvent("test", new TestEvent())
                .withWebEvent("share", new ShareEvent())
                .configure();
        DatabaseManager.getInstance().init(this);
    }
}
