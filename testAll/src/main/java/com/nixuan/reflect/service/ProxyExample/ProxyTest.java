package com.nixuan.reflect.service.ProxyExample;

import com.nixuan.reflect.service.interfaceAndImpl.UserService;
import com.nixuan.reflect.service.interfaceAndImpl.UserServiceImpl;
import org.junit.Test;


public class ProxyTest {

    @Test
    public void testProxy(){
        final UserService userService = new UserServiceImpl();
        UserService userServiceProxy = (UserService) new MyProxyFactory(userService).getProxyInstance();
        userServiceProxy.printMessage(123,"Tom");
    }

}
