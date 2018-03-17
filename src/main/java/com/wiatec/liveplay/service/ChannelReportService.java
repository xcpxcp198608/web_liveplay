package com.wiatec.liveplay.service;

import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.common.result.ResultMaster;
import com.wiatec.liveplay.common.result.XException;
import com.wiatec.liveplay.common.utils.TextUtil;
import com.wiatec.liveplay.dao.ChannelReportDao;
import com.wiatec.liveplay.entities.ChannelReportInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author xuchengpeng
 * @date 03/08/2017
 */
@Service
public class ChannelReportService {

    @Resource
    private ChannelReportDao channelReportDao;

    public List<ChannelReportInfo> selectAll(){
        return channelReportDao.selectAll();
    }

    public ResultInfo insertOne(ChannelReportInfo channelReportInfo){
        if(TextUtil.isEmpty(channelReportInfo.getUserName())){
            throw new XException("username error");
        }
        if(TextUtil.isEmpty(channelReportInfo.getChannelName())){
            throw new XException("Channel Name error");
        }
        if(TextUtil.isEmpty(channelReportInfo.getMessage())){
            throw new XException("Error message is empty");
        }
        channelReportDao.insertOne(channelReportInfo);
        return ResultMaster.success("sent successfullys");
    }
}
