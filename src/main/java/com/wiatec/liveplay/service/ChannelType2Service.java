package com.wiatec.liveplay.service;

import com.wiatec.liveplay.dao.ChannelType2Dao;
import com.wiatec.liveplay.entities.ChannelType2Info;
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
public class ChannelType2Service {

    @Resource
    private ChannelType2Dao channelType2Dao;

    public List<ChannelType2Info> selectByType(String type){
        return channelType2Dao.selectByType(type);
    }
}
