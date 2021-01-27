package com.yuefeng.proxy;

import com.yuefeng.proxy.service.ServiceA;
import com.yuefeng.proxy.service.impl.ServiceAImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyMain {

    public static void main(String[] args) {
        ServiceA serviceA = getProxy(ServiceAImpl.class);
        serviceA.sayHello();
    }

    static class SimpleInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("cglib entering: " + method.getName());
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("cglib leaving: " + method.getName());
            return result;
        }
    }

    private static  <T> T getProxy(Class cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new SimpleInterceptor());
        return (T)enhancer.create();
    }


}
