package com.bind.eventbus.logic;


import com.bind.eventbus.event.CustomerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.AsyncEventBus;

@Component
public class Publisher {
	@Autowired
	private  AsyncEventBus eventBus;



	public void publishCustomer(String filePath, String taskid, String userid,int count) {
		final CustomerEvent event = new CustomerEvent(filePath,taskid,userid, count);
		eventBus.post(event);
	}
}