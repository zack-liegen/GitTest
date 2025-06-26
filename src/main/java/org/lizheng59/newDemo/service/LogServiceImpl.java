package org.lizheng59.newDemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.lizheng59.newDemo.annotation.FunctionParamers;
import org.lizheng59.newDemo.entity.LogInfo;
import org.lizheng59.newDemo.mapper.LogInfoMapper;
import org.lizheng59.newDemo.service.impl.LogService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Service
public class LogServiceImpl implements LogService {
    @Resource
    private LogInfoMapper logInfoMapper;
    @Override
    public void insertLogInfo(String url, HttpServletRequest request){
        String ip = request.getRemoteAddr();
        LogInfo logInfo = new LogInfo();
        logInfo.setUrl(url);
        logInfo.setIp(ip);
        // 获取当前的Timestamp
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        logInfo.setTimestamp(timestamp);
        logInfoMapper.insert(logInfo);
    }
    @Override
    public Page<LogInfo> getLogInfoList(int pageSize, int currentPage){
        Page<LogInfo> page = new Page<>(currentPage, pageSize);
        return logInfoMapper.selectPage(page, new QueryWrapper<>());
    }
    @Override
    public int getLogInfoCount(){
        return logInfoMapper.selectCount(new QueryWrapper<>());
    }

}
