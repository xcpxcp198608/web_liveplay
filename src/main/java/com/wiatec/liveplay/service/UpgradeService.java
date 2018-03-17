package com.wiatec.liveplay.service;

import com.wiatec.liveplay.common.result.EnumResult;
import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.common.result.XException;
import com.wiatec.liveplay.common.utils.TokenUtil;
import com.wiatec.liveplay.dao.UpgradeDao;
import com.wiatec.liveplay.entities.UpgradeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * update service
 */
@Service
public class UpgradeService extends BaseService<UpgradeInfo>{

    @Resource
    private UpgradeDao upgradeDao;

    public ResultInfo<UpgradeInfo> query(String token){
        ResultInfo<UpgradeInfo> resultInfo = new ResultInfo<>();
        if(!TokenUtil.tokenValidate(token)){
            throw new XException(EnumResult.ERROR_UNAUTHORIZED);
        }
        List<UpgradeInfo> upgradeInfoList = upgradeDao.selectUpgrade();
        return setListResult(resultInfo, upgradeInfoList);
    }
}
