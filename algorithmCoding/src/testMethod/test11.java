package testMethod;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-09-15 22:10
 **/
public class test11 {

    public static void main(String[] args) {
        String baseJvm="-server -Xms4g -Xmx4g -Xmn2g -XX:SurvivorRatio=10 -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=500m -XX:MaxDirectMemorySize=512m -XX:ReservedCodeCacheSize=240M -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSMaxAbortablePrecleanTime=5000 -XX:+CMSClassUnloadingEnabled -XX:CMSInitiatingOccupancyFraction=80 -XX:+UseCMSInitiatingOccupancyOnly -XX:+ParallelRefProcEnabled -XX:+DisableExplicitGC -XX:+ExplicitGCInvokesConcurrent -Dsun.rmi.dgc.server.gcInterval=2592000000 -Dsun.rmi.dgc.client.gcInterval=2592000000 -verbose:gc-Xloggc:${APP_HOME}/logs/gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintTenuringDistribution -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${APP_HOME}/logs/java_pid_%p.hprof -XX:ErrorFile=${APP_HOME}/logs/hs_err_%p.log -XX:+PrintCommandLineFlags -XX:+UseCompressedOops -XX:-UseBiasedLocking -XX:-OmitStackTraceInFastThrow -XX:AutoBoxCacheMax=20000 -XX:+AlwaysPreTouch -Djava.awt.headless=true -XX:-UseCounterDecay -XX:-TieredCompilation -Djava.security=file:/dev/urandom -Dsun.net.client.defaultConnectTimeout=10000 -Dsun.net.client.defaultReadTimeout=30000 -Dproject.name=${PROJECT_NAME} -Dapp.id=${PROJECT_NAME}";
        String dcJvm = "-Xms7g  -Xmn9g -Xmx8g";
        String res = mergeJvmEnvironment(baseJvm,dcJvm);
        //System.out.println(res);
        print(res);
    }

    /*private JvmEnvironmentVo mergeJvmEnvironment(JvmEnvironmentVo baseJvmEnvironment, JvmEnvironmentVo dcJvmEnvironment){
        if (dcJvmEnvironment == null || dcJvmEnvironment.getJvm().trim().length() < 1){
            return baseJvmEnvironment;
        }
        if (dcJvmEnvironment.getJvm().indexOf("-server") != -1){
            return dcJvmEnvironment;
        }
        if (baseJvmEnvironment == null || baseJvmEnvironment.getJvm().trim().length() < 1){
            return null;
        }
        Map<String,Integer> valueToIndex = new HashMap<>();
        ArrayList<String[]> help = new ArrayList<>();
       // ArrayList<Map<String,String>> help = new ArrayList<>();
        Integer[] index = {0};
        String baseJvm = baseJvmEnvironment.getJvm().trim();
        String[] allParams = baseJvm.split(" ");
        for (String param : allParams) {
            if (param.length() < 1){
                continue;
            }
            Map<String,String> map = new HashMap<>();
            String[] keyValue = param.trim().split("=");
            if (keyValue.length == 2){
                help1.add(new String[]{keyValue[0],"="+keyValue[1]});
                map.put(keyValue[0],"="+keyValue[1]);
                valueToIndex.put(keyValue[0],index);
            }else if (keyValue.length == 1){
                if ("-server".equals(keyValue[0])){
                    map.put(keyValue[0],"");
                    valueToIndex.put(keyValue[0],index);
                }else if (keyValue[0].indexOf("-Xms")==0){
                    map.put("-Xms",keyValue[0].substring(4));
                    valueToIndex.put("-Xms",index);
                }else if (keyValue[0].indexOf("-Xmx")==0){
                    map.put("-Xmx",keyValue[0].substring(4));
                    valueToIndex.put("-Xmx",index);
                }else if (keyValue[0].indexOf("-Xmn")==0){
                    map.put("-Xmn",keyValue[0].substring(4));
                    valueToIndex.put("-Xmn",index);
                }else{
                    map.put(keyValue[0],"");
                    valueToIndex.put(keyValue[0],index);
                }
            }else{
                map.put(param,"");
                valueToIndex.put(keyValue[0],index);
            }
            help.add(map);
            index++;
        }
        String dcJvm = dcJvmEnvironment.getJvm().trim();
        String[] allDcParams = dcJvm.split(" ");
        for (String dcParam : allDcParams) {
            String[] dcKeyValue = dcParam.trim().split("=");
            if (dcKeyValue.length == 2){
                if (valueToIndex.containsKey(dcKeyValue[0])){
                    Integer paramIndex = valueToIndex.get(dcKeyValue[0]);
                    help.get(paramIndex).put(dcKeyValue[0],dcKeyValue[1]);
                }else{
                    Map<String,String> map = new HashMap<>();
                    map.put(dcKeyValue[0],dcKeyValue[1]);
                    valueToIndex.put(dcKeyValue[0],index++);
                    help.add(map);
                }
            }else if (dcKeyValue.length == 1){
                String key = dcKeyValue[0];
                if (valueToIndex.containsKey(key)){
                    continue;
                }else if (key.indexOf("-Xms") == 0){
                    if (valueToIndex.containsKey("-Xms")){
                        help.get(valueToIndex.get("-Xms")).put("-Xms",key.substring(4));
                    }else{
                        Map<String,String> map = new HashMap<>();
                        map.put("-Xms",key.substring(4));
                        help.add(map);
                        valueToIndex.put(key,index++);
                    }
                }else if (key.indexOf("-Xmx") == 0){
                    if (valueToIndex.containsKey("-Xmx")){
                        help.get(valueToIndex.get("-Xmx")).put("-Xmx",key.substring(4));
                    }else{
                        Map<String,String> map = new HashMap<>();
                        map.put("-Xmx",key.substring(4));
                        help.add(map);
                        valueToIndex.put(key,index++);
                    }
                }else if (key.indexOf("-Xmn") == 0){
                    if (valueToIndex.containsKey("-Xmn")){
                        help.get(valueToIndex.get("-Xmn")).put("-Xmn",key.substring(4));
                    }else{
                        Map<String,String> map = new HashMap<>();
                        map.put("-Xmn",key.substring(4));
                        help.add(map);
                        valueToIndex.put(key,index++);
                    }
                }else{
                    Map<String,String> map = new HashMap<>();
                    map.put(key,"");
                    help.add(map);
                    valueToIndex.put(key,index++);
                }
            }else{
                if (valueToIndex.containsKey(dcParam)){
                    continue;
                }else{
                    Map<String,String> map = new HashMap<>();
                    map.put(dcParam,"");
                    help.add(map);
                    valueToIndex.put(dcParam,index++);
                }
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < help.size(); i++) {
                Map<String,String> map = help.get(i);

            }
        }



    }*/

    private static String mergeJvmEnvironment(String baseJvm, String dcJvm) {
        if (dcJvm == null || dcJvm.trim().length() < 1) {
            return baseJvm;
        }
        if (dcJvm.indexOf("-server") != -1) {
            return dcJvm;
        }
        if (baseJvm == null || baseJvm.trim().length() < 1) {
            return null;
        }
        Map<String, Integer> valueToIndex = new HashMap<>();
        ArrayList<String[]> help = new ArrayList<>();
        Integer[] index = {0};
        baseJvm = baseJvm.trim();
        getBaseJvmEnviromentParam(help,valueToIndex,baseJvm,index);
        dcJvm = dcJvm.trim();
        dcJvmMergeIntoBaseJvm(help,valueToIndex,dcJvm);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < help.size(); i++) {
            String[] temp = help.get(i);
            sb.append(temp[0]).append(temp[1]).append(" ");
        }
        return sb.toString();
    }

    /**
     * 从基本jvm参数中将参数提取出来，放到help中
     *
     *
     * */
    private static void getBaseJvmEnviromentParam(List<String[]> help, Map<String, Integer> valueToIndex, String baseJvm, Integer[] index){
        if (baseJvm == null || baseJvm.trim().length() < 1){
            return;
        }
        String[] allParams = baseJvm.split(" ");
        for (String param : allParams) {
            if (param.length() < 1){
                continue;
            }
            String[] keyValue = param.trim().split("=");
            if (keyValue.length == 2){
                help.add(new String[]{keyValue[0],"="+keyValue[1]});
                valueToIndex.put(keyValue[0],index[0]);
            }else if (keyValue.length == 1){
                if ("-server".equals(keyValue[0])){
                    help.add(new String[]{keyValue[0],""});
                    valueToIndex.put(keyValue[0],index[0]);
                }else if (keyValue[0].indexOf("-Xms")==0){
                    help.add(new String[]{"-Xms",keyValue[0].substring(4)});
                    valueToIndex.put("-Xms",index[0]);
                }else if (keyValue[0].indexOf("-Xmx")==0){
                    help.add(new String[]{"-Xmx",keyValue[0].substring(4)});
                    valueToIndex.put("-Xmx",index[0]);
                }else if (keyValue[0].indexOf("-Xmn")==0){
                    help.add(new String[]{"-Xmn",keyValue[0].substring(4)});
                    valueToIndex.put("-Xmn",index[0]);
                }else{
                    help.add(new String[]{keyValue[0],""});
                    valueToIndex.put(keyValue[0],index[0]);
                }
            }else{
                help.add(new String[]{param,""});
                valueToIndex.put(keyValue[0],index[0]);
            }
            index[0]++;
        }
    }

    private static void dcJvmMergeIntoBaseJvm(List<String[]> help, Map<String, Integer> valueToIndex, String dcJvm){
        String[] allDcParams = dcJvm.split(" ");
        for (String dcParam : allDcParams) {
            String[] dcKeyValue = dcParam.trim().split("=");
            if (dcKeyValue.length == 2){
                if (valueToIndex.containsKey(dcKeyValue[0])){
                    Integer paramIndex = valueToIndex.get(dcKeyValue[0]);
                    help.get(paramIndex)[1] = "="+dcKeyValue[1];
                }else{
                    help.add(new String[]{dcKeyValue[0],"="+dcKeyValue[1]});
                }
            }else if (dcKeyValue.length == 1){
                String key = dcKeyValue[0];
                if (valueToIndex.containsKey(key)){
                    continue;
                }else if (key.indexOf("-Xms") == 0){
                    if (valueToIndex.containsKey("-Xms")){
                        help.get(valueToIndex.get("-Xms"))[1] = key.substring(4);
                    }else{
                        help.add(new String[]{"-Xms",key.substring(4)});
                    }
                }else if (key.indexOf("-Xmx") == 0){
                    if (valueToIndex.containsKey("-Xmx")){
                        help.get(valueToIndex.get("-Xmx"))[1] = key.substring(4);
                    }else{
                        help.add(new String[]{"-Xms",key.substring(4)});
                    }
                }else if (key.indexOf("-Xmn") == 0){
                    if (valueToIndex.containsKey("-Xmn")){
                        help.get(valueToIndex.get("-Xmn"))[1] = key.substring(4);
                    }else{
                        help.add(new String[]{"-Xmn",key.substring(4)});
                    }
                }else{
                    help.add(new String[]{key,""});
                }
            }else{
                if (valueToIndex.containsKey(dcParam)){
                    continue;
                }else{
                    help.add(new String[]{dcParam,""});
                }
            }
        }
    }

    private static void print(String s){
        if (s == null || s.length() < 1){
            return;
        }
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
