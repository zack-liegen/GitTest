package org.lizheng59.newDemo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.lizheng59.newDemo.annotation.EnableServiceProxy;
import org.lizheng59.newDemo.annotation.FunctionParamers;
import org.lizheng59.newDemo.entity.LogInfo;

import javax.servlet.http.HttpServletRequest;

@EnableServiceProxy(enabled = true)
public interface LogService {
    void insertLogInfo(String url, HttpServletRequest request);
    @FunctionParamers(url = "###")
    Page<LogInfo> getLogInfoList(int pageSize, int currentPage);
    @FunctionParamers(url = "@@@")
    int getLogInfoCount();
}
