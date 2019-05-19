package com.mx.testmail;

import com.mx.corelibrary.app.CoreConfig;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CoreConfig.init(this)
                .withApiHost("http://mock.fulingjie.com/mock/api/")
                .configure();
    }
}
