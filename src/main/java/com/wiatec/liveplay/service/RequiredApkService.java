package com.wiatec.liveplay.service;

import com.wiatec.liveplay.dao.RequiredApkDao;
import com.wiatec.liveplay.entities.RequiredApkInfo;
import com.wiatec.liveplay.entities.UpgradeInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * update service
 * @author patrick
 */
@Service
public class RequiredApkService extends BaseService<UpgradeInfo>{

    @Resource
    private RequiredApkDao requiredApkDao;

    public RequiredApkInfo selectByName(String name){
        return requiredApkDao.selectByName(name);
    }
}
