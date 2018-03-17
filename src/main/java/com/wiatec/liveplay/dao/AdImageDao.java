package com.wiatec.liveplay.dao;


import com.wiatec.liveplay.entities.ImageInfo;

import java.util.List;

/**
 * mapping AdImage.xml
 */
public interface AdImageDao {

    List<ImageInfo> selectAll();
    ImageInfo selectById(int id);
    void deleteById(int id);
    void insertOne(ImageInfo imageInfo);
    void updateOne(ImageInfo imageInfo);
}
