package com.wiatec.liveplay.entities;

public class ViewLogInfo {

    private String channelName;
    private int count;
    private String duration;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ViewLogInfo{" +
                "channelName='" + channelName + '\'' +
                ", count=" + count +
                ", duration=" + duration +
                '}';
    }
}
