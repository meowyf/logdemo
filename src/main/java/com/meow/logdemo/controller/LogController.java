package com.meow.logdemo.controller;

import com.meow.logdemo.annotation.LogAnn;
import com.meow.logdemo.bean.Log;
import com.meow.logdemo.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Log Controller
 */
@Controller
@RequestMapping("log")
@Api(value = "log test controller（类描述）")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * query log
     * @param log
     * @return
     */
    @Operation(summary = "我是日志查询的接口（方法描述）") //参数描述 隐藏接口之类的。。。。。
    @LogAnn(moduleName = "日志管理", buttonName = "查询日志") //日志记录只需要一个注解
    @RequestMapping("/queryLog")
    @ResponseBody
    public List<Log> queryLog(Log log){
        return logService.queryLogs(log);
    }
}
