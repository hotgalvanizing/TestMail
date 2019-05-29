package com.mx.testmail;

import com.mx.corelibrary.activities.ProxyActivity;
import com.mx.corelibrary.gelegates.LatteDelegate;

public class MainActivity extends ProxyActivity {
    @Override
    public LatteDelegate setRootDelegate() {
        return new SimpleDelegate();
    }

    @Override
    public void post(Runnable runnable) {

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
}
