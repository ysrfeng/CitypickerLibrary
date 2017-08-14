package com.ysr.citypickerlibrary;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by ysr on 2017/8/14 12:29.
 * 邮箱 ysr200808@163.com
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}
