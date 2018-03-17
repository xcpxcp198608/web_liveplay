package com.wiatec.liveplay.dao;


import com.wiatec.liveplay.entities.LogChannelViewInfo;
import com.wiatec.liveplay.entities.ViewLogInfo;

import java.util.List;

public interface LogChannelViewDao {

    List<LogChannelViewInfo> selectAll();
    List<ViewLogInfo> selectView();
    List<LogChannelViewInfo> selectByName(String channelName);
    LogChannelViewInfo selectOne(LogChannelViewInfo logChannelViewInfo);
    void insertOne(LogChannelViewInfo logChannelViewInfo);
    void updateOne(LogChannelViewInfo logChannelViewInfo);
}
