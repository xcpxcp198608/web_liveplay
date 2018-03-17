package com.wiatec.liveplay.common.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author patrick
 */
class CacheList<T>{

    private List<T> list;

    public CacheList(List<T> list){
        this.list=list;
    }
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}