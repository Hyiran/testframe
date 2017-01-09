package com.scloudpay.testframe.admin.channel.dao;

import java.util.List;

import com.scloudpay.testframe.admin.channel.entity.ChannelInfo;

public interface ChannelInfoMapper {
	
    List<ChannelInfo> getAllChannel() throws Exception;
    
    int inertChannelInfo(ChannelInfo channel) throws Exception;

    int delChannelInfo(String batchNo) throws Exception;
    
    int insertChannelInfoHis(String batchNo) throws Exception;
}