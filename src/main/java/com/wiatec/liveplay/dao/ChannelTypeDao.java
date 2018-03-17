package com.wiatec.liveplay.dao;

import com.wiatec.liveplay.entities.ChannelTypeInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapping ChannelTypeController.xml
 */
@Repository
public interface ChannelTypeDao {
    List<ChannelTypeInfo> queryByType(int type);
}
