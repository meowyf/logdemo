package com.meow.logdemo.bean;

/**
 * 日志实体
 */
public class Log {

    //id 主键
    private Long id;
    //模块名
    private String moduleName;
    //按钮名
    private String buttonName;
    //操作人
    private String userName;
    //创建时间
    private long createTime;
    //耗时
    private String remarks;

    private long runTime;

    public Log() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public long getRunTime() {
        return runTime;
    }

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                ", buttonName='" + buttonName + '\'' +
                ", userName='" + userName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", remarks='" + remarks + '\'' +
                ", runTime=" + runTime +
                '}';
    }

    public Log(Long id, String moduleName, String buttonName, String userName, long createTime, String remarks, long runTime) {
        this.id = id;
        this.moduleName = moduleName;
        this.buttonName = buttonName;
        this.userName = userName;
        this.createTime = createTime;
        this.remarks = remarks;
        this.runTime = runTime;
    }
}
