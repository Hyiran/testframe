/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.mock<br/>
 * <b>文件名：</b>HttpServerMock.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月10日-下午12:00:36<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.mock.third;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scloudpay.testframe.mock.third.config.ThridMockConfig;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 *
 * HttpServerMock 启动HTTP服务，模拟第三方渠道响应
 * 
 * @author TanDong
 * 2017年1月10日 下午12:00:36
 * 
 * @version 1.0.0
 *
 */
public abstract class HttpServerMock implements ServerMock {
	
	Logger logger = LoggerFactory.getLogger(HttpServerMock.class);
	
	EventLoopGroup bossGroup;
	
    EventLoopGroup workerGroup;

	/* (non-Javadoc)
	 * @see com.scloudpay.testframe.mock.ServerMock#start()
	 */
	public void start() {
        try {
        	int port = this.getMockConfig().getPort();
        	bossGroup = new NioEventLoopGroup();
        	workerGroup = new NioEventLoopGroup();
        	
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                                @Override
                                public void initChannel(SocketChannel ch) throws Exception {
                                    // server端发送的是httpResponse，所以要使用HttpResponseEncoder进行编码
                                    ch.pipeline().addLast(new HttpResponseEncoder());
                                    // server端接收到的是httpRequest，所以要使用HttpRequestDecoder进行解码
                                    ch.pipeline().addLast(new HttpRequestDecoder());
                                    ch.pipeline().addLast(getHandler());
                                }
                            }).option(ChannelOption.SO_BACKLOG, 128) 
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = b.bind(port).sync();

            f.channel().closeFuture().sync();
        }catch(Exception e){
        	logger.error("HTTP服务器启动失败", e);
        } 
	}
	
	/* (non-Javadoc)
	 * @see com.scloudpay.testframe.mock.ServerMock#stop()
	 */
	public void stop() {
		if(null != workerGroup && !workerGroup.isShutdown()){
			workerGroup.shutdownGracefully();
		}
		if(null != bossGroup && !bossGroup.isShutdown()){
			bossGroup.shutdownGracefully();
		}
	}
	
	public abstract ChannelInboundHandlerAdapter getHandler();
	
	public abstract ThridMockConfig getMockConfig();

}
