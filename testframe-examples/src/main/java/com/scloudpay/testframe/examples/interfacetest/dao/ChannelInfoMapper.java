package com.scloudpay.testframe.examples.interfacetest.dao;

import java.util.List;

import com.scloudpay.testframe.examples.interfacetest.entity.ChannelInfo;

public interface ChannelInfoMapper {
	
    List<ChannelInfo> getAllChannel() throws Exception;
    
    int inertChannelInfo(ChannelInfo channel) throws Exception;

    int delChannelInfo(String batchNo) throws Exception;
    
    int insertChannelInfoHis(String batchNo) throws Exception;
}