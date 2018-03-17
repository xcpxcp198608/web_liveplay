package com.wiatec.liveplay.dao;


import com.wiatec.liveplay.entities.ChannelReportInfo;

import java.util.List;

/**
 *
 * @author xuchengpeng
 * @date 03/08/2017
 */
public interface ChannelReportDao {
    List<ChannelReportInfo> selectAll();
    void insertOne(ChannelReportInfo channelReportInfo);
}
