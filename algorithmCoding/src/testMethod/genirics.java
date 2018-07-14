package testMethod;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class genirics {

    public static void main(String[] args) {
        /*Class<?> clazz = HashSet.class;
        Constructor<?>[] c = clazz.getConstructors();
        for (Constructor<?> d:c) {
            System.out.println(d.toString());
        }*/
        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
