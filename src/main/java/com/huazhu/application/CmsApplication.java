package com.huazhu.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableScheduling
@EnableTransactionManagement
@EnableSwagger2
@SpringBootApplication
public class CmsApplication {

	public static void main(String[] args) {
		System.out.println("=============服务启动开始=============");
		SpringApplication.run(CmsApplication.class, args);
		System.out.println("=============服务启动结束=============");
	}
	
	 
}
