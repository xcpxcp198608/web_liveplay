package com.wiatec.liveplay.api;

import com.wiatec.liveplay.entities.ChannelType1Info;
import com.wiatec.liveplay.service.ChannelType1Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * the controller of channel type information
 * @author patrick
 */
@Controller
@RequestMapping(value = "/channel_type1")
public class ChannelType1 {

    @Resource
    private ChannelType1Service channelType1Service;

    @GetMapping(value = "/{type}/{token}")
    @ResponseBody
    public List<ChannelType1Info> get(@PathVariable String type, @PathVariable("token") String token){
        return channelType1Service.selectByType(type);
    }


}
