package com.bind.eventbus.logic;

import com.bind.eventbus.event.CustomerEvent;
import com.google.common.eventbus.AllowConcurrentEvents;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.Subscribe;

@Component
public class Subscriber{
	@AllowConcurrentEvents//这是个神奇的配置，如果不加线程是同步的，但是加上之后线程不是安全的，需要在自己的代码钟加入锁
	@Subscribe
	public void receiveCustomer(final CustomerEvent event) {
		event.Excute();
		System.out.println("统计数据！！");
	}
	
}