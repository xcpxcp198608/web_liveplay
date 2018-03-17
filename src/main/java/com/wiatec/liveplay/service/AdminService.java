package com.wiatec.liveplay.service;

import com.wiatec.liveplay.common.result.XException;
import com.wiatec.liveplay.dao.AdminDao;
import com.wiatec.liveplay.entities.AdminInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * manager service
 * @author patrick
 */
@Service
public class AdminService {

    @Resource
    private AdminDao adminDao;

    public String validate(AdminInfo adminInfo, HttpSession session){
        if(adminDao.countOne(adminInfo) == 1){
            session.setAttribute("username", adminInfo.getUserName());
            return "redirect:/images/";
        }else{
            throw new XException("authority failure");
        }
    }
}
