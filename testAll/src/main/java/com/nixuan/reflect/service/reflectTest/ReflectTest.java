package com.nixuan.reflect.service.reflectTest;



import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;

public class ReflectTest {

    @Test
    public void testConstructor() throws Exception {
        // 获取class对象
        Class c = Class.forName("com.nixuan.reflect.service.reflectTest.Person");
        // 获取构造器
        Constructor c1 = c.getConstructor();
        Constructor c2 = c.getDeclaredConstructor(int.class,String.class);
        Constructor c3 = c.getConstructor(int.class,String.class,String.class,java.util.Date.class,String.class);
        // 获取反射对象
        Object obj1 = c1.newInstance();
        Person person1 = (Person) c1.newInstance();

        c2.setAccessible(true);
        Object obj2 = c2.newInstance(12,"Tom");
        Person person2 = (Person) c2.newInstance(13,"Tom1");

        Object obj3 = c3.newInstance(23,"John","male",new Date(),"beijing");
        Person person3 = (Person) c3.newInstance(24,"John1","male",new Date(),"shanghai");
        // 打印信息
        System.out.println(obj1.getClass().getSimpleName());
        System.out.println(person1.getName());

        System.out.println(obj2.getClass().getSimpleName());
        System.out.println(person2.getName());

        System.out.println(obj3.getClass().getSimpleName());
        System.out.println(person3.getName());
    }

    @Test
    public void testMethod() throws Exception {
        // 得到class对象
        Class c = Person.class;
        // 得到原对象
        Object obj = c.getConstructor().newInstance();
        // 得到方法
        Method method1 = c.getMethod("getName");
        Method method2 = c.getMethod("setName",String.class);
        Method method3 = c.getDeclaredMethod("printLength", String.class);

        System.out.println("before" + obj);
        method2.invoke(obj,"Tom");
        System.out.println(method1.invoke(obj));
        method3.setAccessible(true);
        System.out.println(method3.invoke(obj,"thisIsAName"));
    }

    @Test
    public void testFiled() throws Exception{
        // 得到class对象
        Person p = new Person();
        Class c = p.getClass();
        // 得到字段
        Field f1 = c.getDeclaredField("name");
        Field[] f2 = c.getDeclaredFields();
        f1.setAccessible(true);
        f1.set(p,"Alice");
        Object name = f1.get(p);
        System.out.println(name);
        System.out.println(f1.getType());
        System.out.println(f1.getName());
    }
}
