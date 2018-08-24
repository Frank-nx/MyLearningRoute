package com.nixuan.reflect.service.interfaceAndImpl;

public class UserServiceImpl implements UserService {


    public int getVodCount(String name) {
        if(name == null){
            return 0;
        }
        return name.length();
    }

    public void printMessage(Integer num, String name) {
        System.out.println(name + "这是一个" + num);
    }
}
