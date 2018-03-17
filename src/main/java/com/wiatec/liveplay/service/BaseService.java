package com.wiatec.liveplay.service;


import com.wiatec.liveplay.common.result.EnumResult;
import com.wiatec.liveplay.common.result.ResultInfo;
import com.wiatec.liveplay.common.result.ResultMaster;
import com.wiatec.liveplay.common.result.XException;

import java.util.List;

/**
 *
 * @author xuchengpeng
 * @date 19/06/2017
 */
public class BaseService<T> {

    protected ResultInfo<T> setListResult(ResultInfo<T> resultInfo, List<T> list){
        if(list == null || list.size() <= 0){
            throw new XException(EnumResult.ERROR_NO_FOUND);
        }
        return ResultMaster.success(list);

    }
}
