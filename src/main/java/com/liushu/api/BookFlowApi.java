package com.liushu.api;

import com.liushu.apidowngrade.BookFlowApiDown;
import com.liushu.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
@FeignClient(value = "liushu-user-service",fallback = BookFlowApiDown.class)
public interface BookFlowApi {
    @GetMapping("/v1/user-book-flows")
    Result cancel(@RequestParam("userId") String userId,@RequestParam("bookFlowId") String bookFlowId);

    @GetMapping("/v1/user-browse-infos")
    Map<String,Object> getUserAndBookFlow(@RequestParam("bookFlowId") String bookFlowId);
}
