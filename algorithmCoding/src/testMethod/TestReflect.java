package testMethod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflect {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException, ClassNotFoundException {
        /*Class c = Student.class;
        Constructor constructor = c.getDeclaredConstructor(int.class,String.class);
        constructor.setAccessible(true);
        Object obj = constructor.newInstance(18,"Tom");
        System.out.println(obj);

        Object obj1 = c.getConstructor().newInstance();
        System.out.println(obj1);

        Constructor[] constructor1 = c.getConstructors();
        System.out.println(Arrays.toString(constructor1));

        Field[] f = c.getDeclaredFields();
        System.out.println(Arrays.toString(f));

        Field f1 = c.getDeclaredField("name");
        f1.setAccessible(true);
        Object obj2 = f1.get(obj);
        System.out.println(obj2);

        f1.set(obj,"Tony");
        System.out.println(obj);

        System.out.println(f1.getType());*/
        Class c = Class.forName("testMethod.Student");
        Object obj = c.getConstructor().newInstance();

        Method m = c.getMethod("setName",String.class);
        m.invoke(obj,"julia");
        System.out.println(m);

        m = c.getDeclaredMethod("testField", String.class);
        m.setAccessible(true);
        Object obj2 = m.invoke(obj,"123456");
        System.out.println(obj2);
    }
}
