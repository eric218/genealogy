package com.dct.swocean;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan("com.dct.swocean.dao")
@EnableAsync
@Controller
public class SwoceanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwoceanApplication.class, args);
	}

	@RequestMapping("/")
	public String demo01() {
		return "demo";
	}

	@RequestMapping("/reg")
	public String demo03() {
		return "reg";
	}
	
	@RequestMapping("/dd")
	public String demo04() {
		return "answer";
	}
}
