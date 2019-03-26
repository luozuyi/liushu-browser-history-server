package com.liushu.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.liushu.api.BookFlowApi;
import com.liushu.entity.BrowseRecord;
import com.liushu.mapper.BrowseRecordMapper;
import com.liushu.service.BrowseRecordService;
import com.liushu.utils.CommonUtil;
import com.liushu.utils.Constants;
import com.liushu.utils.PageHelperNew;
import com.liushu.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author mayn
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BrowseRecordServiceImpl implements BrowseRecordService{
    @Autowired
    private BrowseRecordMapper browseRecordMapper;
    @Autowired
    private BookFlowApi bookFlowApi;
    @Override
    public Result addBrowseRecord(BrowseRecord record,String liushuUserToken) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            String userId = CommonUtil.getUserId(liushuUserToken);
            String bookFlowId = record.getBookFlowId();
            if(StringUtils.isBlank(bookFlowId)){
                code = "-3";
                msg = "流书id不能为空";
            }else{
                BrowseRecord params = new BrowseRecord();
                params.setUserId(userId);
                params.setBookFlowId(record.getBookFlowId());
                Result removteRes = bookFlowApi.cancel(userId,record.getBookFlowId());
                if(Constants.SUCCESS.equals(removteRes.getCode())){
                    List<BrowseRecord> browseRecordList = browseRecordMapper.selectByUserIdAndBookFlowId(params);
                    if(!browseRecordList.isEmpty()){
                        code = "-4";
                        msg = "已经添加过";
                    }else{
                        String uuid = CommonUtil.getUUID();
                        record.setId(uuid);
                        record.setCreateTime(new Date());
                        record.setDelFlag("0");
                        record.setUserId(userId);
                        browseRecordMapper.insertSelective(record);
                        code = Constants.SUCCESS;
                        msg = "成功";
                    }
                }else{
                    code = removteRes.getCode();
                    msg = removteRes.getMsg();
                }

            }
        }catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result recentBrowser(String liushuUserToken,Integer pageNum,Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            String userId = CommonUtil.getUserId(liushuUserToken);
            PageHelperNew.startPage(pageNum,pageSize);
            List<Map<String,Object>> mapList =  browseRecordMapper.selectAllByUserId(userId);
            for (Map<String,Object> mapDate:mapList) {
                String bookFlowId = mapDate.get("bookFlowId").toString();
                Map<String,Object> remoteMap = bookFlowApi.getUserAndBookFlow(bookFlowId);
                if(remoteMap != null && remoteMap.size() > 0){
                    mapDate.putAll(remoteMap);
                }
            }
            PageInfo<Map<String,Object>> page = new PageInfo<>(mapList);
            result.setData(page);
            code = Constants.SUCCESS;
            msg = "成功";
        }catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result deleteBrowser(String liushuUserToken, String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            String userId = CommonUtil.getUserId(liushuUserToken);
            BrowseRecord browseRecord = browseRecordMapper.selectByPrimaryKey(id);
            if(browseRecord == null){
                code = "-3";
                msg = "删除的对象不存在";
            }else if(!userId.equals(browseRecord.getUserId())){
                code = "-4";
                msg = "不是当前用户的浏览记录，无法删除";
            }else {
                browseRecordMapper.deleteByPrimaryKey(id);
                code = Constants.SUCCESS;
                msg = "删除成功";
            }
        }catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result deleteMeBrowser(String liushuUserToken) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            String userId = CommonUtil.getUserId(liushuUserToken);
            browseRecordMapper.deleteAllByUserId(userId);
            code = Constants.SUCCESS;
            msg = "删除成功";
        }catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result selectCountByUserIdToday(String userId) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            Integer count = browseRecordMapper.selectCountByUserIdToday(userId);
            result.setData(count);
            code = Constants.SUCCESS;
            msg = "成功";
        }catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
