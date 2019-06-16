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
                .withApiHost("你的本地服务器地址")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .withWeChatAppId("你的微信AppKey")
                .withWeChatAppSecret("你的微信AppSecret")
                .withJavascriptInterface("latte")
                .withWebEvent("test", new TestEvent())
                .withWebEvent("share", new ShareEvent())
                .configure();
        DatabaseManager.getInstance().init(this);

//        //开启极光推送
//        JPushInterface.setDebugMode(true);
//        JPushInterface.init(this);
//
//        CallbackManager.getInstance()
//                .addCallback(CallbackType.TAG_OPEN_PUSH, new IGlobalCallback() {
//                    @Override
//                    public void executeCallback(@Nullable Object args) {
//                        if (JPushInterface.isPushStopped(Latte.getApplicationContext())) {
//                            //开启极光推送
//                            JPushInterface.setDebugMode(true);
//                            JPushInterface.init(Latte.getApplicationContext());
//                        }
//                    }
//                })
//                .addCallback(CallbackType.TAG_STOP_PUSH, new IGlobalCallback() {
//                    @Override
//                    public void executeCallback(@Nullable Object args) {
//                        if (!JPushInterface.isPushStopped(Latte.getApplicationContext())) {
//                            JPushInterface.stopPush(Latte.getApplicationContext());
//                        }
//                    }
//                });
    }

    //    private void initStetho() {
//        Stetho.initialize(
//                Stetho.newInitializerBuilder(this)
//                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
//                        .build());
//    }
}
