package com.wiatec.liveplay.dao;

import com.wiatec.liveplay.entities.UpgradeInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapping the update.xml
 */
@Repository
public interface UpgradeDao {

    UpgradeInfo selectUpgrade();
}
