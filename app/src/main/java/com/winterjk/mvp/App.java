package com.winterjk.mvp;

import android.app.Application;
import android.content.Context;

/**
 * Created by pengxin on 2017/7/23.
 */

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}
