package com.tm.router;

import android.app.Application;
import android.content.pm.ApplicationInfo;

import com.alibaba.android.arouter.launcher.ARouter;

public class RouterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initArouter();
    }

    private void initArouter() {
        ARouter.init(this);
        if(isDebug()){
            //debug模式打印控制台日志
            ARouter.openLog();
            ARouter.openDebug();
        }
    }

    private boolean isDebug() {
        boolean isDebug = getApplicationInfo() != null &&
                (getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        return isDebug;
    }

}
