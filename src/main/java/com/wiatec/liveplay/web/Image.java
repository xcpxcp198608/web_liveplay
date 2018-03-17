package com.wiatec.liveplay.web;

import com.wiatec.liveplay.Constant;
import com.wiatec.liveplay.entities.ImageInfo;
import com.wiatec.liveplay.service.AdImageService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * web ad image
 * @author patrick
 */
@Controller
@RequestMapping(value = "/images")
public class Image {

    @Resource
    private AdImageService adImageService;


    @RequestMapping(value = "/")
    public String show(Model model, HttpServletRequest request){
        List<ImageInfo> imageInfoList = adImageService.selectAll();
        model.addAttribute("imageInfoList", imageInfoList);
        return "images";
    }

    @RequestMapping(value = "/up")
    public String up(Model model, HttpServletRequest request, int id){
        model.addAttribute("link", "ignore this");
        model.addAttribute("action", "/liveplay/images/upload");
        model.addAttribute("id", id);
        return "upload";
    }

    @RequestMapping(value = "/upload")
    public String upload(Model model, HttpServletRequest request, MultipartFile file, int type, int id) throws IOException {
        if(type == 1){
            String upload_status ;
            String path = request.getSession().getServletContext().getRealPath("/Resource/image/");
            String fileName = file.getOriginalFilename();
            if(!file.isEmpty()){
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, fileName));
                String url = Constant.path.image+fileName;
                request.getSession().setAttribute("url", url);
                request.getSession().setAttribute("fileName", fileName);
                upload_status = "upload successfully";
            }else{
                upload_status = "upload fail";
            }
            model.addAttribute("id", id);
            model.addAttribute("link", "ignore this");
            model.addAttribute("upload_status", upload_status);
            return "upload";
        }else if (type == 2){
            if(id > 0) {
                String url = (String) request.getSession().getAttribute("url");
                String fileName = (String) request.getSession().getAttribute("fileName");
                adImageService.updateOne(id, url, fileName);
            }else {
                String url = (String) request.getSession().getAttribute("url");
                String fileName = (String) request.getSession().getAttribute("fileName");
                adImageService.insertOne(url, fileName);
            }
            return "redirect:/images/";
        }
        return "";
    }

    @RequestMapping(value = "/delete")
    public @ResponseBody String delete(@RequestParam() int id, HttpServletRequest request){
        adImageService.deleteById(id);
        return "{\"code\":200, \"message\":\"delete successfully\"}";
    }


}
