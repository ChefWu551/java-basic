package com.yuefeng.proxy;

import com.yuefeng.proxy.proxys.SdkDynamicProxy;

import java.lang.reflect.Proxy;

public class SdkProxyMain {

    interface ServiceA {
        void sayHello();
    }

    static class ServiceAImpl implements ServiceA {
        @Override
        public void sayHello() {
            System.out.println("serviceA run hello");
        }
    }

    public interface ServiceB {
        void sayWorld();
    }

    static class ServiceBImpl implements ServiceB {
        @Override
        public void sayWorld() {
            System.out.println("serviceB run world");
        }
    }

    public static void main(String[] args) {
        ServiceA realServiceA = new ServiceAImpl();
        ServiceA a = getProxy(ServiceA.class, realServiceA);
//        Proxy.newProxyInstance(ServiceA.class.getClassLoader(), new Class<?>[]{ServiceA.class}, new SdkDynamicProxy(realServiceA));
        a.sayHello();

        ServiceB realServiceB = new ServiceBImpl();
        ServiceB b = getProxy(ServiceB.class, realServiceB);
        b.sayWorld();
    }

    @SuppressWarnings("unchecked")
    private static <T> T getProxy(Class<T> iClass, Object realObject) {
        return (T)Proxy.newProxyInstance(iClass.getClassLoader(), new Class<?>[]{iClass}, new SdkDynamicProxy(realObject));
    }
}
