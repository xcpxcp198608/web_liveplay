package com.wiatec.liveplay.service;

import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.common.result.ResultMaster;
import com.wiatec.liveplay.dao.ChannelType2Dao;
import com.wiatec.liveplay.entities.ChannelType2Info;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author xuchengpeng
 * @date 07/08/2017
 */
@Service
public class ChannelType2Service {

    @Resource
    private ChannelType2Dao channelType2Dao;

    public ResultInfo<ChannelType2Info> selectByType(String type){
        List<ChannelType2Info> channelType2InfoList = channelType2Dao.selectByType(type);
        return ResultMaster.success(channelType2InfoList);
    }
}
