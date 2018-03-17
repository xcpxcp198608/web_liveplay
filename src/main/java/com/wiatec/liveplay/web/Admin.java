package com.wiatec.liveplay.web;

import com.wiatec.liveplay.entities.AdminInfo;
import com.wiatec.liveplay.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


/**
 * @author patrick
 */
@Controller
@RequestMapping(value = "/admin")
public class Admin {

    @Resource
    private AdminService adminService;

    @PostMapping(value = "/login")
    public String login(@ModelAttribute AdminInfo adminInfo, HttpSession session){
        return adminService.validate(adminInfo, session);
    }

    @RequestMapping(value = "/logout")
    public String logout(@ModelAttribute AdminInfo adminInfo){
        return "redirect:/";
    }

}
