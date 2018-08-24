package com.nixuan.reflect.service.cglibExample;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglibFactory {
    private Object target;

    public MyCglibFactory(Object target){
        this.target = target;
    }

    public Object getCglibInstance(){
        // 创建代理对象
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("动态代理之前");
                System.out.println(target.getClass().getSimpleName());
                System.out.println(method.getName());
                Object res= methodProxy.invokeSuper(o,objects);
                System.out.println("动态代理之后");
                return res;
            }
        });
         return enhancer.create();
    }



}
