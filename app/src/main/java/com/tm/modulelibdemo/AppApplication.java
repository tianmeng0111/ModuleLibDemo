package com.tm.modulelibdemo;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tm.provider.IProviderForApplication;

/**
 * 如果报错
 * Caused by: com.alibaba.android.arouter.exception.HandlerException: ARouter::ARouter init logistics center exception! [com.alibaba.android.arouter.routes.ARouter$$Providers$$router]
 * 问题：ARouter缓存
 * 解决：卸载应用重新安装
 */
public class AppApplication extends Application implements IProviderForApplication {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

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

    public static Context getContext() {
        return context;
    }

    /**
     * 实现接口 IProviderForApplication
     */
    @Override
    public void login() {
        Toast.makeText(this, "login in AppApplication", Toast.LENGTH_SHORT).show();
    }
}
