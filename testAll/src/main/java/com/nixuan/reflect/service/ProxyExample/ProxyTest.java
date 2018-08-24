package com.nixuan.reflect.service.ProxyExample;

import com.nixuan.reflect.service.interfaceAndImpl.UserService;
import com.nixuan.reflect.service.interfaceAndImpl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void testProxy(){
        final UserService userService = new UserServiceImpl();
        UserService userServiceProxy = (UserService) new MyProxyFactory(userService).getProxyInstance();
        userServiceProxy.printMessage(123,"Tom");
    }

}
