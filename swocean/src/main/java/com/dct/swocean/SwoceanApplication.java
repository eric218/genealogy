package com.dct.swocean;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.dct.swocean.dao")
@EnableAsync
public class SwoceanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwoceanApplication.class, args);
	}

}
