package com.wiatec.liveplay.service;

import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.common.result.ResultMaster;
import com.wiatec.liveplay.dao.ChannelType1Dao;
import com.wiatec.liveplay.entities.ChannelType1Info;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author xuchengpeng
 * @date 07/08/2017
 */
@Service
public class ChannelType1Service {

    @Resource
    private ChannelType1Dao channelType1Dao;

    public ResultInfo<ChannelType1Info> selectByType(String type){
        List<ChannelType1Info> channelType1InfoList = channelType1Dao.selectByType(type);
        return ResultMaster.success(channelType1InfoList);
    }
}
