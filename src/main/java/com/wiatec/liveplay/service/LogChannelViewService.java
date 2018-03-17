package com.wiatec.liveplay.service;

import com.wiatec.liveplay.common.utils.TimeUtil;
import com.wiatec.liveplay.dao.LogChannelViewDao;
import com.wiatec.liveplay.entities.LogChannelViewInfo;
import com.wiatec.liveplay.entities.ViewLogInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author xuchengpeng
 * @date 03/08/2017
 */
@Service
public class LogChannelViewService {

    @Resource
    private LogChannelViewDao logChannelViewDao;

    public List<ViewLogInfo> selectAll(){
        List<ViewLogInfo> viewLogInfoList = logChannelViewDao.selectView();
        for(ViewLogInfo viewLogInfo: viewLogInfoList){
            viewLogInfo.setDuration(TimeUtil.formatDuration(Long.parseLong(viewLogInfo.getDuration())));
        }
        return viewLogInfoList;
    }

    public List<LogChannelViewInfo> selectByName(String channelName){
        List<LogChannelViewInfo> logChannelViewInfoList = logChannelViewDao.selectByName(channelName);
        for(LogChannelViewInfo logChannelViewInfo : logChannelViewInfoList){
            logChannelViewInfo.setViewStrTime(TimeUtil.formatDuration(logChannelViewInfo.getViewTime()));
        }
        return logChannelViewInfoList;
    }

    public void insertOne(LogChannelViewInfo logChannelViewInfo){
        logChannelViewInfo.setStartTime(TimeUtil.getCurrentStringTime());
        logChannelViewDao.insertOne(logChannelViewInfo);
    }

    public void updateOne(LogChannelViewInfo logChannelViewInfo){
        LogChannelViewInfo logChannelViewInfo1 = logChannelViewDao.selectOne(logChannelViewInfo);
        String endTime = TimeUtil.getCurrentStringTime();
        long sTime = TimeUtil.getUnixTimeFromString(logChannelViewInfo1.getStartTime());
        long eTime = System.currentTimeMillis();
        long vTime = eTime - sTime;
        logChannelViewInfo.setEndTime(endTime);
        logChannelViewInfo.setViewTime(vTime);
        logChannelViewDao.updateOne(logChannelViewInfo);
    }
}
