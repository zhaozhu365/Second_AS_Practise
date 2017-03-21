package com.example.zhaozhu.second_as_practise;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhaozhu on 17/3/10.
 */

public class App extends Application {

    private static Context mContext;

    public static Context getAppContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

}
