package com.wiatec.liveplay.web;

import com.wiatec.liveplay.Constant;
import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.entities.ChannelInfo;
import com.wiatec.liveplay.service.ChannelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author patrick
 */
@Controller
@RequestMapping(value = "/channel")
public class WebChannel {

    @Resource
    private ChannelService channelService;

    @RequestMapping(value = "/show")
    public String show(){
        return "channel/show";
    }

    @RequestMapping(value = "/list/{category}")
    @ResponseBody
    public ResultInfo<ChannelInfo> list(@PathVariable String category){
        return channelService.queryChannelByCountry(category, Constant.key.token);
    }
}
