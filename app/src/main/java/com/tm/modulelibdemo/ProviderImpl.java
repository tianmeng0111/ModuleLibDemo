package com.tm.modulelibdemo;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tm.provider.IProvider1;
import com.tm.provider.RouterPath;

@Route(path = RouterPath.APP_SERVICE)
public class ProviderImpl implements IProvider1 {

    @Override
    public void login() {
        Toast.makeText(AppApplication.getContext(), "login in ProviderImpl", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {

    }
}
