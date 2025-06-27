package org.lizheng59.newDemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.lizheng59.newDemo.annotation.EnableControllerProxy;
import org.lizheng59.newDemo.entity.LogInfo;
import org.lizheng59.newDemo.model.Result;
import org.lizheng59.newDemo.service.impl.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/log")
@EnableControllerProxy
public class LogController {
    @Autowired
    LogService LogService;

    @RequestMapping(value = "/list")
    public Result<Page<LogInfo>> listLog(
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(required = false, defaultValue = "1") Integer currentPage,
            HttpServletRequest request
    ) {
        LogService.insertLogInfo("/log/list", request);
        Page<LogInfo> res = LogService.getLogInfoList(pageSize, currentPage);
        if (res.getCurrent() > res.getPages()) {
            return Result.error("无更多信息", res);
        }
        return Result.success("成功", res);
    }
    @RequestMapping(value = "/list2")
    public Result<Page<LogInfo>> list2Log(
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(required = false, defaultValue = "1") Integer currentPage,
            HttpServletRequest request
    ) {
        Page<LogInfo> res = LogService.getLogInfoList(pageSize, currentPage);
        if (res.getCurrent() > res.getPages()) {
            return Result.error("无更多信息", res);
        }
        return Result.success("成功", res);
    }
    @RequestMapping(value = "/count")
    public Result<Integer> countLog(HttpServletRequest request) {
        LogService.insertLogInfo("/log/count", request);
        int res = LogService.getLogInfoCount();
        return Result.success("成功", res);
    }
}
