package com.wiatec.liveplay.api;

import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.entities.UpgradeInfo;
import com.wiatec.liveplay.service.UpgradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * the controller of update information
 * @author patrick
 */
@Controller
@RequestMapping(value = "/upgrade")
public class Upgrade {

    @Resource
    private UpgradeService upgradeService;

    @GetMapping(value = "/{token}")
    @ResponseBody
    public ResultInfo<UpgradeInfo> get(@PathVariable("token") String token){
        return upgradeService.query(token);
    }

}
