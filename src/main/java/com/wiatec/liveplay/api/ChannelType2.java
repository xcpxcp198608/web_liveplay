package com.wiatec.liveplay.api;

import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.entities.ChannelType2Info;
import com.wiatec.liveplay.service.ChannelType2Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * the controller of channel type information
 * @author patrick
 */
@Controller
@RequestMapping(value = "/channel_type2")
public class ChannelType2 {

    @Resource
    private ChannelType2Service channelType2Service;

    @GetMapping(value = "/{type}/{token}")
    @ResponseBody
    public ResultInfo<ChannelType2Info> get(@PathVariable String type, @PathVariable("token") String token){
        return channelType2Service.selectByType(type);
    }


}
