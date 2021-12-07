package com.tm.router.utils;

import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tm.provider.IProvider1;
import com.tm.provider.IProviderForApplication;
import com.tm.provider.RouterPath;

public class IProviderUtils {

    /**
     * 如果是app依赖，则可取到 ApoApplication 中实现方法
     * @param context 账户相关上下文
     * @return 可能null
     */
    public static IProviderForApplication getAppApplication(Context context) {
        if (context.getApplicationContext() instanceof IProviderForApplication) {
            return ((IProviderForApplication) context.getApplicationContext());
        } else  {
            return null;
        }
    }

    /**
     * 利用路由找到app中的接口的实现类
     * 注意不可线程中使用
     * @return router作为单独的module，此值为null
     */
    public static IProvider1 getProvider() {
        IProvider1 navigation = (IProvider1)
                ARouter.getInstance().build(RouterPath.APP_SERVICE).navigation();
        return navigation;
    }

}
