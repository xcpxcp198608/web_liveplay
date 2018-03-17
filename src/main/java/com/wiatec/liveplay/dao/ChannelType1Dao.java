package com.wiatec.liveplay.dao;

import com.wiatec.liveplay.entities.ChannelType1Info;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapping ChannelTypeController.xml
 */
@Repository
public interface ChannelType1Dao {
    List<ChannelType1Info> selectByType(String type);
}
