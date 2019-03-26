package com.liushu.mapper;

import com.liushu.entity.BrowseRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BrowseRecordMapper {
    /**
     * 删除
     * @param id 主键
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 添加
     * @param record 对象
     * @return
     */
    int insert(BrowseRecord record);

    /**
     * 添加
     * @param record 对象
     * @return
     */
    int insertSelective(BrowseRecord record);

    /**
     *查询
     * @param id 主键
     * @return
     */
    BrowseRecord selectByPrimaryKey(String id);

    /**
     * 修改
     * @param record 对象
     * @return
     */
    int updateByPrimaryKeySelective(BrowseRecord record);

    /**
     * 修改
     * @param record 对象
     * @return
     */
    int updateByPrimaryKey(BrowseRecord record);

    /**
     * 查询
     * @param record 参数
     * @return
     */
    List<BrowseRecord> selectByUserIdAndBookFlowId(BrowseRecord record);

    /**
     * 查询
     * @return
     */
    List<BrowseRecord> selectAll();

    /**
     * 查询用户的浏览记录
     * @param userId 用户id
     * @return
     */
    List<Map<String,Object>> selectAllByUserId(String userId);

    /**
     * 删除
     * @param userId 用户id
     * @return
     */
    int deleteAllByUserId(String userId);

    /**
     * 查询进入用户阅读的数量
     * @param userId
     * @return
     */
    int selectCountByUserIdToday(String userId);
}