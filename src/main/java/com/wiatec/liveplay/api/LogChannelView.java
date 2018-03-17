package com.wiatec.liveplay.api;

import com.wiatec.liveplay.entities.LogChannelViewInfo;
import com.wiatec.liveplay.service.LogChannelViewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author patrick
 */
@Controller
@RequestMapping(value = "/log_view")
public class LogChannelView {

    @Resource
    private LogChannelViewService logChannelViewService;

    @PostMapping(value = "/start")
    public @ResponseBody String start(@ModelAttribute LogChannelViewInfo logChannelViewInfo){
        logChannelViewService.insertOne(logChannelViewInfo);
        return "success";
    }

    @PostMapping(value = "/end")
    public @ResponseBody String end(@ModelAttribute LogChannelViewInfo logChannelViewInfo){
        logChannelViewService.updateOne(logChannelViewInfo);
        return "success";
    }
}
