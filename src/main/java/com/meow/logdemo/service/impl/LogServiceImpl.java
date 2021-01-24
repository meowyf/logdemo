package com.meow.logdemo.service.impl;

import com.meow.logdemo.bean.Log;
import com.meow.logdemo.service.LogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Log Service实现
 */
@Service
public class LogServiceImpl implements LogService {

    /**
     * query log
     * @param log
     * @return
     */
    @Override
    public List<Log> queryLogs(Log log) {
        List<Log> logs = new ArrayList<>();
        logs.add(new Log(null, "myf", "moduleName01", "buttonName01", 0, "备注01", 0));
        logs.add(new Log(null, "zwb", "moduleName02", "buttonName02", 0, "备注02", 0));
        logs.add(new Log(null, "lpf", "moduleName03", "buttonName03", 0, "备注03", 0));
        logs.add(new Log(null, "myf01", "moduleName04", "buttonName04", 0, "备注04", 0));
        logs.add(new Log(null, "zwb01", "moduleName05", "buttonName05", 0, "备注05", 0));
        logs.add(new Log(null, "rzz", "moduleName06", "buttonName06", 0, "备注06", 0));
        return logs;
    }

    /**
     * add log
     * @param log
     * @return
     */
    @Override
    public String saveLog(Log log) {
        //todo 模拟新增开始 后期新增到MongoDB Mysql Oracle...
        System.out.println("---模拟新增操作日志--start---");
        System.out.println("新增的日志信息为：" + log.toString());
        System.out.println("---模拟新增操作日志--end---");
        return "模拟新增操作日志成功";
    }
}
