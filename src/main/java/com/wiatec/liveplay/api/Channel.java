package com.wiatec.liveplay.api;

import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.entities.ChannelInfo;
import com.wiatec.liveplay.service.ChannelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * the controller of channel information
 * @author patrick
 */
@Controller
@RequestMapping(value = "/channels")
public class Channel {

    @Resource
    private ChannelService channelService;

    /**
     * respond the query channel by country request from user
     * @param country request parameter
     * @return channel list
     */
    @GetMapping(value = "/list/{country}/{token}")
    @ResponseBody
    public ResultInfo<ChannelInfo> list(@PathVariable("country") String country,
                                        @PathVariable("token") String token){
        return channelService.queryChannelByCountry(country, token);
    }

    /**
     * respond the search request from application
     * @param key   name like key
     * @param token token
     * @return channel list
     */
    @GetMapping(value = "/search/{key}/{token}")
    @ResponseBody
    public ResultInfo<ChannelInfo> search(@PathVariable("key") String key,
                                                      @PathVariable("token") String token){
        return channelService.searchByName(key, token);
    }



}
