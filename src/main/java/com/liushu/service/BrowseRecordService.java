package com.liushu.service;

import com.liushu.entity.BrowseRecord;
import com.liushu.utils.Result;

/**
 * @author mayn
 */
public interface BrowseRecordService {
    /**
     *添加记录
     * @param record 对象
     * @param liushuUserToken 凭据
     * @return
     */
    Result addBrowseRecord(BrowseRecord record,String liushuUserToken);

    /**
     * 查询用户最近的30条记录
     * @param liushuUserToken
     * @return
     */
    Result recentBrowser(String liushuUserToken,Integer pageNum,Integer pageSize);

    /**
     * 删除我的浏览记录
     * @param liushuUserToken 凭据
     * @param id 浏览记录主键id
     * @return
     */
    Result deleteBrowser(String liushuUserToken,String id);

    /**
     * 删除我的所有浏览记录
     * @param liushuUserToken
     * @return
     */
    Result deleteMeBrowser(String liushuUserToken);

    /**
     * 查询今天阅读数量
     * @param liushuUserToken 凭据
     * @return
     */
    Result selectCountByUserIdToday(String liushuUserToken);
}
