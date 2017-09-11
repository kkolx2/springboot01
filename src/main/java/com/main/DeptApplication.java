package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.dao.DeptDao;

import lombok.extern.java.Log;

@SpringBootApplication
@ComponentScan("com.example")  		// Bean등록할 객체가 있는 타 패키지를 지정한다.
@Log
public class DeptApplication implements CommandLineRunner{
	// DeptApplication ==> Setting File 의미.
	
	@Autowired
	DeptDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(DeptApplication.class, args);
		// DeptApplicaton.class의 설정을 읽어온 후 객체를 등록 및 실행
		// 1. @ComponentScan Annotation에 의하여 com.example 이하의 모든 @component를 찾아 등록함.
		// 2. 등록된 객체의 생성.
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("@@@@");
		log.info("@@@@ "+DeptApplication.class);
		log.info("@@@@");
		
		dao.selectAll().forEach(e -> {
			System.out.println(e);
			log.info(e.toString());
			// 내부 반복자 무명 구현 객체를 반복 호출
		});
	}
	
}
