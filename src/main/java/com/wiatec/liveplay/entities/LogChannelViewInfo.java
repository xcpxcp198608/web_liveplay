package com.wiatec.liveplay.entities;

public class LogChannelViewInfo {

    private int id;
    private String tag;
    private String channelName;
    private String username;
    private String mac;
    private String startTime;
    private String endTime;
    private long viewTime;
    private String viewStrTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public long getViewTime() {
        return viewTime;
    }

    public void setViewTime(long viewTime) {
        this.viewTime = viewTime;
    }

    public String getViewStrTime() {
        return viewStrTime;
    }

    public void setViewStrTime(String viewStrTime) {
        this.viewStrTime = viewStrTime;
    }

    @Override
    public String toString() {
        return "LogChannelViewInfo{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", channelName='" + channelName + '\'' +
                ", username='" + username + '\'' +
                ", mac='" + mac + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", viewTime=" + viewTime +
                ", viewStrTime='" + viewStrTime + '\'' +
                '}';
    }
}
