package com.iqiyi.vip.allocation.service.impl;

import com.iqiyi.vip.allocation.entity.TaskJob;
import com.iqiyi.vip.allocation.mapper.TablesContributionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Component("testDataBaseLanguages")
public class TestDataBaseLanguages {

    @Autowired
    TablesContributionMapper tablesContributionMapper;

    public List<TaskJob> findAll(String currentUsedTable){
        return tablesContributionMapper.findAll(currentUsedTable);
    }

    public Set<String> findAllNames(String currentUsedTable, Date currentDate){
        return tablesContributionMapper.findAllTokens(currentUsedTable,currentDate);
    }

    /**
     * 根据日期和表名查询数据的id
     * @param  currentUsedTable 当前要使用的数据库名
     * @param currentDate
     * @param actionToken
     * @return
     */
    public Integer findIdByDateAndName(String currentUsedTable, Date currentDate, String actionToken){
        return tablesContributionMapper.findIdByDateAndToken(currentUsedTable,currentDate,actionToken);
    }

    /**
     * 根据日期和状态查询表名
     * @param currentUsedTable 当前要使用的数据库名
     * @param currentDate
     * @param status
     * @return
     */
    public Set<String> findNamesByDateAndStatus(String currentUsedTable, Date currentDate, String status){
        return tablesContributionMapper.findTokensByDateAndStatus(currentUsedTable,currentDate,status);
    }

    /**
     * 根据日期和表名查询状态
     * @param currentUsedTable 当前要使用的数据库名
     * @param currentDate
     * @param actionToken
     * @return
     */
    public String findStatusValueByDateAndName(String currentUsedTable, Date currentDate, String actionToken){
        return tablesContributionMapper.findStatusValueByDateAndToken(currentUsedTable,currentDate,actionToken);
    }

    /**
     * 插入已分发表的相应的状态属性
     * @param currentUsedTable 当前要使用的数据库名
     * @param currentDate
     * @param actionToken
     * @param status
     * @param IP
     * @param lastChangeTime
     * @return
     */
    public Integer insertTaskJobValues(String currentUsedTable, Date currentDate, String actionToken, String status, String IP, Timestamp lastChangeTime){
        return tablesContributionMapper.insertTaskJobValues(currentUsedTable,currentDate,actionToken,status,IP,lastChangeTime);
    }

    /**
     * 通过日期和表名来更新状态和时间戳
     * @param currentUsedTable 当前要使用的数据库名
     * @param currentDate
     * @param actionToken
     * @param status
     * @param lastChangeTime
     * @return
     */
    public Integer updateStatusValueByDateAndName(String currentUsedTable, Date currentDate, String actionToken, String status, Timestamp lastChangeTime){
        return tablesContributionMapper.updateStatusValueByDateAndToken(currentUsedTable,currentDate,actionToken,status,lastChangeTime);
    }

    /**
     * 通过日期和表名来更新状态,IP和时间戳
     * @param currentUsedTable 当前要使用的数据库名
     * @param currentDate
     * @param actionToken
     * @param status
     * @param IP
     * @param lastChangeTime
     * @return
     */
    public Integer updateStatusIPTimestampByDateAndName(String currentUsedTable, Date currentDate, String actionToken, String status, String IP, Timestamp lastChangeTime){
        return tablesContributionMapper.updateStatusIPTimestampByDateAndToken(currentUsedTable,currentDate,actionToken,status,IP,lastChangeTime);
    }

    /**
     * 根据日期和表名查询IP
     * @param currentUsedTable 当前要使用的数据库名
     * @param currentDate
     * @param actionToken
     * @return
     */
    public String findIPValueByDateAndName(String currentUsedTable, Date currentDate, String actionToken){
        return tablesContributionMapper.findIPValueByDateAndToken(currentUsedTable,currentDate,actionToken);
    }

    /**
     * 根据日期和表名查询上一次插入的时间戳
     * @param currentUsedTable 当前要使用的数据库名
     * @param currentDate
     * @param actionToken
     * @return
     */
    public Timestamp findLastChangeTimeByDateAndName(String currentUsedTable, Date currentDate, String actionToken){
        return tablesContributionMapper.findLastChangeTimeByDateAndToken(currentUsedTable,currentDate,actionToken);
    }

    /**
     * 根据日期和表名来删除数据
     * @param currentUsedTable 当前要使用的数据库名
     * @param currentDate
     * @param actionToken
     * @return
     */
    public Integer deleteDataByDateAndName(String currentUsedTable, Date currentDate, String actionToken){
        return tablesContributionMapper.deleteDataByDateAndToken(currentUsedTable,currentDate,actionToken);
    }
}
