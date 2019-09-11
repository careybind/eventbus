package com.bind.eventbus.config;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@Configuration
public class EnventConfig {
	@Bean
	AsyncEventBus eventBus() {

		final ThreadPoolTaskExecutor executor = executor1();
		return new AsyncEventBus(executor);
	}
	@Bean
	public ThreadPoolTaskExecutor executor1(){
		/**
		 *
		 */
        /*
        org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
        private int corePoolSize = 1;
        private int maxPoolSize = 2147483647;
        private int queueCapacity = 2147483647;
        private int keepAliveSeconds = 60;
        private boolean allowCoreThreadTimeOut = false;
        * */
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(100);
		executor.setQueueCapacity(1000);
		// executor.setKeepAliveSeconds(600);
		// executor.setAllowCoreThreadTimeOut(true);
		return executor;
		/**
		 *
		 */
	}
}