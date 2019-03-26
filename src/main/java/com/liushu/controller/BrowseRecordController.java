package com.liushu.controller;

import com.liushu.entity.BrowseRecord;
import com.liushu.service.BrowseRecordService;
import com.liushu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mayu
 */
@RestController
public class BrowseRecordController {
    @Autowired
    private BrowseRecordService browseRecordService;

    /**
     * 添加浏览记录
     * @param record 对象
     * @param liushuUserToken 凭据
     * @return
     */
    @PostMapping(value = "v1/auth/browse-records")
    public Result addBrowseRecord(BrowseRecord record, @CookieValue String liushuUserToken) {
        return browseRecordService.addBrowseRecord(record, liushuUserToken);
    }

    /**
     * 分页查询用户的浏览记录
     * @param liushuUserToken 凭据
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @GetMapping(value = "v1/auth/browse-records/pagination")
    public Result recentBrowser(@CookieValue String liushuUserToken, Integer pageNum, Integer pageSize) {
        return browseRecordService.recentBrowser(liushuUserToken,pageNum,pageSize);
    }

    /**
     * 删除当前用户的浏览记录
     * @param liushuUserToken 凭据
     * @param id 浏览记录主键id
     * @return
     */
    @DeleteMapping(value = "v1/auth/browse-records/id")
    public Result deleteBrowser(@CookieValue String liushuUserToken, String id) {
        return browseRecordService.deleteBrowser(liushuUserToken,  id);
    }

    /**
     * 删除所有的我的浏览记录
     * @param liushuUserToken 凭据
     * @return
     */
    @DeleteMapping(value = "v1/auth/browse-records")
    public Result deleteMeBrowser(@CookieValue String liushuUserToken) {
        return browseRecordService.deleteMeBrowser(liushuUserToken);
    }

    /**
     * 查询用户今日阅读数量
     * @param userId 用户id
     * @return
     */
    @GetMapping(value = "v1/browse-records/counts")
    public Result selectCountByUserIdToday(String userId) {
        return browseRecordService.selectCountByUserIdToday(userId);
    }
}
