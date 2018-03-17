package com.wiatec.liveplay.api;

import com.wiatec.liveplay.entities.RequiredApkInfo;
import com.wiatec.liveplay.service.RequiredApkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author patrick
 */
@Controller
@ResponseBody
@RequestMapping(value = "/required")
public class RequiredApk {

    @Resource
    private RequiredApkService requiredApkService;

    @RequestMapping(value = "/")
    public RequiredApkInfo getByName(String name){
        return requiredApkService.selectByName(name);
    }
}
