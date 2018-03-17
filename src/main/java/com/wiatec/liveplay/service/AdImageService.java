package com.wiatec.liveplay.service;

import com.wiatec.liveplay.dao.AdImageDao;
import com.wiatec.liveplay.entities.ImageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * AdImage service
 * @author patrick
 */
@Service
public class AdImageService {

    @Resource
    private AdImageDao adImageDao;

    public List<ImageInfo> selectAll(){
        return adImageDao.selectAll();
    }

    public ImageInfo selectById(int id){
        return adImageDao.selectById(id);
    }

    public void deleteById(int id){
        adImageDao.deleteById(id);
    }

    public void insertOne(String url, String fileName){
        if(fileName == null){
            return;
        }
        ImageInfo imageInfo = new ImageInfo(fileName, url,"1");
        adImageDao.insertOne(imageInfo);
    }

    public void updateOne(int id, String url, String  fileName){
        if(fileName == null){
            return;
        }
        ImageInfo imageInfo = new ImageInfo(id, fileName, url,"1");
        adImageDao.updateOne(imageInfo);
    }
}
