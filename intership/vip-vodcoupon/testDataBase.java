package com.qiyi.boss;

import com.iqiyi.vip.allocation.service.impl.TableDistributionImpl;
import com.iqiyi.vip.allocation.service.impl.TestDataBaseLanguages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class testDataBase {

    @Autowired
    public TableDistributionImpl tableDistribution;

    public static String currentUsedTable = "boss_send_vod_coupon_job";
    public static Date currentDate;

    static {
        try {
            currentDate = getCurrentDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String tableName = "table13";
    public static String status = "send";
    public static String IP = "127.3.3.3";
    public static Timestamp lastChangeTimestamp;

    static {
        try {
            lastChangeTimestamp = getCurrentTimestamp();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

   /* public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        TestDataBaseLanguages testDataBaseLanguages =(TestDataBaseLanguages)context.getBean("testDataBaseLanguages");

       *//* List<TaskJob> taskJobs = testDataBaseLanguages.findAll("boss_send_vod_coupon_job");
        for (TaskJob t : taskJobs) {
            System.out.println(t.toString());
        }*//*

       *//* Set<String> allNames = testDataBaseLanguages.findAllTokens(currentUsedTable, currentDate);
        for (String t : allNames) {
            System.out.println(t);
        }*//*

        *//*Integer idByDateAndName = testDataBaseLanguages.findIdByDateAndToken(currentUsedTable, currentDate, tableName);
        System.out.println(idByDateAndName);*//*

       *//* Set<String> namesByDateAndStatus = testDataBaseLanguages.findTokensByDateAndStatus(currentUsedTable, currentDate, status);
        for (String t : namesByDateAndStatus) {
            System.out.println(t);
        }*//*

        *//*String statusValueByDateAndName = testDataBaseLanguages.findStatusValueByDateAndToken(currentUsedTable, currentDate, tableName);
        System.out.println(statusValueByDateAndName);*//*


        *//*Integer integer = null;
        try {
            integer = testDataBaseLanguages.insertTaskJobValues(currentUsedTable, currentDate, tableName, status, IP, lastChangeTimestamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(integer);*//*


        *//*Integer finish = testDataBaseLanguages.updateStatusValueByDateAndToken(currentUsedTable, currentDate, tableName, "finish", lastChangeTimestamp);
        System.out.println(finish);*//*

        *//*Integer integer = testDataBaseLanguages.updateStatusIPTimestampByDateAndToken(currentUsedTable, currentDate, tableName, status, IP, lastChangeTimestamp);
        System.out.println(integer);*//*

        *//*String ipValueByDateAndName = testDataBaseLanguages.findIPValueByDateAndToken(currentUsedTable, currentDate, tableName);
        System.out.println(ipValueByDateAndName);*//*

        *//*Timestamp lastChangeTimeByDateAndName = testDataBaseLanguages.findLastChangeTimeByDateAndToken(currentUsedTable, currentDate, tableName);
        System.out.println(lastChangeTimeByDateAndName.toString());*//*

        Integer integer = testDataBaseLanguages.deleteDataByDateAndToken(currentUsedTable, currentDate, tableName);
        System.out.println(integer);

    }*/

    public static Date getCurrentDate() throws ParseException {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(date);
        Date sqlDate = null;
        java.util.Date utilDate = dateFormat.parse(currentDate);
        sqlDate=new Date(utilDate.getTime());

        return sqlDate;
    }


    public static Timestamp getCurrentTimestamp() throws ParseException {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(date);
        Timestamp sqlTimestamp = null;
        java.util.Date utilTime = dateFormat.parse(currentTime);
        sqlTimestamp=new Timestamp(utilTime.getTime());

        return sqlTimestamp;
    }

}


