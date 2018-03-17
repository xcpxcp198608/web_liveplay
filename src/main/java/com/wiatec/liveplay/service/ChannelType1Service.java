package com.wiatec.liveplay.service;

import com.wiatec.liveplay.dao.ChannelType1Dao;
import com.wiatec.liveplay.entities.ChannelType1Info;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public List<ChannelType1Info> selectByType(String type){
        return channelType1Dao.selectByType(type);
    }
}
