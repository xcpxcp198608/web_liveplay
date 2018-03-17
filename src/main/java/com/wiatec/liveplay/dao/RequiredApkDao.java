package com.wiatec.liveplay.dao;

import com.wiatec.liveplay.entities.RequiredApkInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapping the update.xml
 */
@Repository
public interface RequiredApkDao {

    List<RequiredApkInfo> selectAll();
    RequiredApkInfo selectByName(String name);
}
