package com.wiatec.liveplay.entities;

/**
 * Created by xuchengpeng on 03/08/2017.
 */
public class ChannelReportInfo {
    private int id;
    private String userName;
    private String  channelName;
    private String message;
    private String reportTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    @Override
    public String toString() {
        return "ChannelReportInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", channelName='" + channelName + '\'' +
                ", message='" + message + '\'' +
                ", reportTime='" + reportTime + '\'' +
                '}';
    }
}
