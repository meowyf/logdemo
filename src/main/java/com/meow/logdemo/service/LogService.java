package com.meow.logdemo.service;

import com.meow.logdemo.bean.Log;

import java.util.List;

/**
 * Log interface
 */
public interface LogService {

    /**
     * query log
     * @param log
     * @return
     */
    List<Log> queryLogs(Log log);

    /**
     * 增加log
     * @return
     */
    String saveLog(Log log);
}
