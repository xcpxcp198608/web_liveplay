package com.wiatec.liveplay.dao;

import com.wiatec.liveplay.entities.ChannelType2Info;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapping ChannelTypeController.xml
 */
@Repository
public interface ChannelType2Dao {
    List<ChannelType2Info> selectByType(String type);
}
