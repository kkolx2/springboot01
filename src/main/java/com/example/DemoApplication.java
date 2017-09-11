package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.Dept;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class DemoApplication{

//	@Autowired					//DI (Dependency Injection) 의존 주입
//	DeptDao dao;
	
	@Bean						// Dept를 호출한 결과를 Bean Factory에 등록함.
	public Dept dept(){
		log.info("*****");
		log.info("***** DemoApplication.dept()");
		log.info("*****");
		return new Dept(90,"xxx","yyy");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args).close();
	}

}
