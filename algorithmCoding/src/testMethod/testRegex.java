package testMethod;

import java.util.Arrays;

public class testRegex {

    public static void main(String[] args) {
        String regex = "[, /-]";
        String s = "12 3,4/5-6";
        String[] arr = s.split(regex);
        System.out.println(Arrays.toString(arr));
    }
}
