package com.wiatec.liveplay.api;

import com.wiatec.liveplay.entities.ImageInfo;
import com.wiatec.liveplay.service.AdImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * AdImage Controller
 * @author patrick
 */
@Controller
@RequestMapping(value = "/adimage")
public class AdImage {

    @Resource
    private AdImageService adImageService;

    @GetMapping(value = "/")
    @ResponseBody
    public List<ImageInfo> getAll(){
        return adImageService.selectAll();
    }
}
