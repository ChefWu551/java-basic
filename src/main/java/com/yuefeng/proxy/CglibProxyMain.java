package com.yuefeng.proxy;

import com.yuefeng.proxy.interceptor.SimpleInterceptor;
import com.yuefeng.proxy.service.ServiceA;
import com.yuefeng.proxy.service.impl.ServiceAImpl;
import net.sf.cglib.proxy.Enhancer;

public class CglibProxyMain {

    public static void main(String[] args) {
        ServiceA serviceA = getProxy(ServiceAImpl.class);
        serviceA.sayHello();
    }

    private static <T> T getProxy(Class cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new SimpleInterceptor());
        return (T) enhancer.create();
    }


}
