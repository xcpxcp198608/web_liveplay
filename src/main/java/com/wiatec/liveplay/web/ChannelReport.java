package com.wiatec.liveplay.web;

import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.entities.ChannelReportInfo;
import com.wiatec.liveplay.service.ChannelReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author xuchengpeng
 * @date 03/08/2017
 */
@Controller
@RequestMapping(value = "/report")
public class ChannelReport {

    @Resource
    private ChannelReportService channelReportService;

    @RequestMapping(value = "/")
    public String show(Model model, HttpServletRequest request){
        List<ChannelReportInfo> channelReportInfoList = channelReportService.selectAll();
        model.addAttribute("channelReportInfoList", channelReportInfoList);
        return "reports";
    }

    @PostMapping(value = "/send")
    @ResponseBody
    public ResultInfo upload(@ModelAttribute ChannelReportInfo channelReportInfo){
        return channelReportService.insertOne(channelReportInfo);
    }

}
