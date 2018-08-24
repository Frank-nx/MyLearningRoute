package testDemo;

import org.junit.jupiter.api.Test;

public class TestClass {


    public void imple(final String name){
        //final String s = name;
        System.out.println(name.hashCode());
        TestMethodClass tmc = new TestMethodClass();
        tmc.workMethod(new TestClassInterface() {
            public void work() {
                System.out.println(name);
            }
        });
    }

    @Test
    public void test(){
        imple("tom");
        imple("jack");
    }
}
