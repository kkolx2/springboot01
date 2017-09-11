package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.DeptDao;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class DemoApplication implements CommandLineRunner{

	@Autowired					//DI (Dependency Injection) 의존 주입
	DeptDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("###");
		log.info("### DemoApplication.run()....");
		log.info("###");
		
		log.info(dao.selectAll().toString());
		
	}
	


}
