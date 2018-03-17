package com.wiatec.liveplay.service;

import com.wiatec.liveplay.common.result.EnumResult;
import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.common.result.XException;
import com.wiatec.liveplay.common.utils.TokenUtil;
import com.wiatec.liveplay.dao.ChannelTypeDao;
import com.wiatec.liveplay.entities.ChannelTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * channel type service
 * @author patrick
 */
@Service
public class ChannelTypeService extends BaseService<ChannelTypeInfo> {

    @Resource
    private ChannelTypeDao channelTypeDao;

    public ResultInfo<ChannelTypeInfo> queryByType(String token, int type){
        ResultInfo<ChannelTypeInfo> resultInfo = new ResultInfo<>();
        if(!TokenUtil.tokenValidate(token)){
            throw new XException(EnumResult.ERROR_UNAUTHORIZED);
        }
        List<ChannelTypeInfo> channelTypeInfoList = channelTypeDao.queryByType(type);
        return setListResult(resultInfo , channelTypeInfoList);
    }

}
