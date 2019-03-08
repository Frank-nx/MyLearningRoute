package testMethod;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testRegex {

    public static void main(String[] args) {
        String ip = "10.10.14.156";
        String content = "upstream act.vip.iqiyi.com {\n" +
                "\n" +
                "        server 10.12.18.25:8080;\n" +
                "        server 10.10.14.155:8080;\n" +
                "  \n" +
                "        server 10.10.14.156:8080;\n" +
                "        server 10.10.14.14:8080;\n" +
                "#       server 10.10.14.15:8080;\n" +
                "        server 10.110.20.113:8080;\n" +
                "        server 10.110.20.116:8080;\n" +
                "        server 10.110.20.120:8080;\n" +
                "        server 10.110.20.121:8080;\n" +
                "        server 10.110.19.43:8080;\n" +
                "        server 10.110.19.44:8080;\n" +
                "#       server 10.110.22.56:8080;\n" +
                "        keepalive 256;\n" +
                "        check interval=3000 rise=2 fall=5 timeout=3000 type=http;\n" +
                "    }";
        String reg = "^[\\s]*server\\s+" + ip + "\\s*[:;].*$";
        //Matcher m = Pattern.compile(reg, Pattern.MULTILINE).matcher(content);
         Matcher m = Pattern.compile(reg, Pattern.DOTALL).matcher(content);
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (m.find()) {
            String group = m.group();
            System.out.println(group);
        }
    }
}
