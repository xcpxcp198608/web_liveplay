package com.wiatec.liveplay.api;

import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.entities.ChannelTypeInfo;
import com.wiatec.liveplay.service.ChannelTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * the controller of channel type information
 */
@Controller
@RequestMapping(value = "/channel_type")
public class ChannelType {

    @Resource
    private ChannelTypeService channelTypeService;

    @GetMapping(value = "/{type}/{token}")
    @ResponseBody
    public ResultInfo<ChannelTypeInfo> get(@PathVariable("token") String token,
                                    @PathVariable("type") int type){
        return channelTypeService.queryByType(token, type);
    }


}
