package com.minsait.service.items.app;

import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

public class LocalRibbonClientConfiguration {

	@Bean
	public ServerList<Server> ribbonServerList() {

		return new StaticServerList<>(new Server("localhost", 8001), new Server("localhost", 9001));
	}
}
