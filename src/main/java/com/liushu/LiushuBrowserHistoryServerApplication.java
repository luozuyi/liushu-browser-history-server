package com.liushu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author luozuyi
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LiushuBrowserHistoryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiushuBrowserHistoryServerApplication.class, args);
	}

}
