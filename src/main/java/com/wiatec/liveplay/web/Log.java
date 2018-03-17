package com.wiatec.liveplay.web;

import com.wiatec.liveplay.entities.LogChannelViewInfo;
import com.wiatec.liveplay.entities.ViewLogInfo;
import com.wiatec.liveplay.service.LogChannelViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/log")
public class Log {

    @Resource
    private LogChannelViewService logChannelViewService;

    @RequestMapping(value = "/view")
    public String view(Model model, HttpServletRequest request){
        List<ViewLogInfo> viewLogInfoList = logChannelViewService.selectAll();
        model.addAttribute("viewLogInfoList", viewLogInfoList);
        return "log";
    }

    @RequestMapping(value = "/detail")
    public String view(Model model, HttpServletRequest request, String channelName){
        List<LogChannelViewInfo> logChannelViewInfoList = logChannelViewService.selectByName(channelName);
        model.addAttribute("logChannelViewInfoList", logChannelViewInfoList);
        return "log_detail";
    }
}
