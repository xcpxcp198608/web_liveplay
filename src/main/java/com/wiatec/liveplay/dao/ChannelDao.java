package com.wiatec.liveplay.dao;

import com.wiatec.liveplay.entities.ChannelInfo;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * mapping Channel.xml
 * @author patrick
 */
@Repository
public interface ChannelDao {
    List<ChannelInfo> queryAll();
    List<ChannelInfo> queryByCountry(String country);
    List<ChannelInfo> queryByName(String key);
}
