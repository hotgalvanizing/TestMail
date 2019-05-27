package com.mx.testmail;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.mx.corelibrary.app.CoreConfig;
import com.mx.maillibrary.icon.FontEcModule;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CoreConfig.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://mock.fulingjie.com/mock/api/")
//                .withInterceptor(new DebugInterceptor("test", R.raw.test))
//                .withWeChatAppId("你的微信AppKey")
//                .withWeChatAppSecret("你的微信AppSecret")
//                .withJavascriptInterface("latte")
//                .withWebEvent("test", new TestEvent())
//                .withWebEvent("share", new ShareEvent())
                //添加Cookie同步拦截器
                .withWebHost("https://www.baidu.com/")
//                .withInterceptor(new AddCookieInterceptor())
                .configure();
    }
}
