package com.qiyi.boss;

import com.iqiyi.vip.allocation.entity.TaskJob;
import com.iqiyi.vip.allocation.mapper.TablesContributionMapper;
import com.iqiyi.vip.allocation.service.impl.TableDistributionImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class testMapper {

  /*  private static String currentUsedTable = "boss_send_vod_coupon_job";
    private static Date currentDate = testDataBase.currentDate;
    private static String tableName = "table13";
    private static String status = "send";
    private static String IP = "127.3.3.3";
    private static Timestamp lastChangeTimestamp = testDataBase.lastChangeTimestamp;*/

   /* public static void main(String[] args) {

        *//*new Thread(new Runnable() {
            @Override
            public void run() {
                AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
                TableDistributionImpl tableDistribution =(TableDistributionImpl)context.getBean("tableDistribution");
                tableDistribution.init();

            }
        });*//*
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        TableDistributionImpl tableDistribution =(TableDistributionImpl)context.getBean("tableDistribution");
       // tableDistribution.init();
        *//*String IP = tableDistribution.getLocalIP();
        System.out.println(IP);*//*
    }*/
}


