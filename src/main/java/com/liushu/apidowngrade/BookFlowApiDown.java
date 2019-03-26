package com.liushu.apidowngrade;

import com.liushu.api.BookFlowApi;
import com.liushu.utils.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Component
public class BookFlowApiDown implements BookFlowApi {

    @Override
    public Result cancel(String userId, String bookFlowId) {
        Result result = new Result();
        result.setMsg("请稍后再试");
        result.setCode("-88");
        return result;
    }

    @Override
    public Map<String, Object> getUserAndBookFlow(String bookFlowId) {
        Map<String, Object> map = new HashMap<>(16);
        return map;
    }
}
