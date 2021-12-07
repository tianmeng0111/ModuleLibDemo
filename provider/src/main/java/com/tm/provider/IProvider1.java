package com.tm.provider;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 外部暴露接口，供router调用app
 */
public interface IProvider1 extends IProvider {
    void login();
}
