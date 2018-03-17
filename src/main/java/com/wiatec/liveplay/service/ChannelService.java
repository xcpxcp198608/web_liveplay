package com.wiatec.liveplay.service;

import com.wiatec.liveplay.common.result.EnumResult;
import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.common.result.XException;
import com.wiatec.liveplay.common.utils.AESUtil;
import com.wiatec.liveplay.common.utils.TokenUtil;
import com.wiatec.liveplay.dao.ChannelDao;
import com.wiatec.liveplay.entities.ChannelInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * channel service , the bridge of request controller and the channelDao
 * @author patrick
 */
@Service
public class ChannelService extends BaseService<ChannelInfo> {

    @Resource
    private ChannelDao channelDao;

    /**
     * invoke channelDao query channel information by country
     * @param country country name from request parameter
     * @param token user token from request parameter
     * @return
     */
    public ResultInfo<ChannelInfo> queryChannelByCountry(String country, String token){
        ResultInfo<ChannelInfo> resultInfo = new ResultInfo<>();
        if(!TokenUtil.tokenValidate(token)){
            throw new XException(EnumResult.ERROR_UNAUTHORIZED);
        }
        List<ChannelInfo> channelInfoList = channelDao.queryByCountry(country);
        if(channelInfoList == null || channelInfoList.size() <= 0){
            throw new XException(EnumResult.ERROR_NO_FOUND);
        }
        for(ChannelInfo channelInfo: channelInfoList){
            String url = AESUtil.encrypt(channelInfo.getUrl(), AESUtil.KEY);
            channelInfo.setUrl(url);
        }
        return setListResult(resultInfo , channelInfoList);
    }

    public ResultInfo<ChannelInfo> searchByName(String key, String token){
        ResultInfo<ChannelInfo> resultInfo = new ResultInfo<>();
        if(!TokenUtil.tokenValidate(token)){
            throw new XException(EnumResult.ERROR_UNAUTHORIZED);
        }
        List<ChannelInfo> channelInfoList = channelDao.queryByName(key);
        for(ChannelInfo channelInfo: channelInfoList){
            String url = AESUtil.encrypt(channelInfo.getUrl(), AESUtil.KEY);
            channelInfo.setUrl(url);
        }
        return setListResult(resultInfo , channelInfoList);
    }

    /**
     * return all of channel information in the table of 'channel'
     * @return
     */
    public List<ChannelInfo> queryAll(){
        return channelDao.queryAll();
    }

}
