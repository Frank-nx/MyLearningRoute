package com.nixuan.reflect.service.cglibExample;

import com.nixuan.reflect.service.interfaceAndImpl.UserServiceImpl;
import org.junit.Test;


public class CglibTest {

    @Test
    public void testCglib(){
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceImpl cglib = (UserServiceImpl) new MyCglibFactory(userService).getCglibInstance();
        cglib.printMessage(987,"Tim");

    }
}
