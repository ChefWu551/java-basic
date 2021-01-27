package com.yuefeng.proxy.service.impl;

import com.yuefeng.proxy.service.ServiceA;

public class ServiceAImpl implements ServiceA {
    @Override
    public void sayHello() {
        System.out.println("serviceA run hello");
    }
}
