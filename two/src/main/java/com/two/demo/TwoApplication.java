package com.two.demo;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class TwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwoApplication.class, args);
	}

	@PostConstruct
	public void started() {     // 시간 한국 시간으로 맞춤
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
		System.out.println("현재시각 : "+new Date());
	}
}
