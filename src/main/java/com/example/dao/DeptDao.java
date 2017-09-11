package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.example.domain.Dept;

import lombok.extern.java.Log;

@Component				// Spring Annotation 하위 패키지 경로내에서 @Component설정되어있는 Class를 Bean 객체로 등록한다.
@Log					// Lombok Annotation 
public class DeptDao {
	
	
	public DeptDao(){
		log.info("###");
		log.info("### DeptDao() ..... ###");
		log.info("###");
	}
	
	@PostConstruct
	public void PostConstruct() {
		log.info("###");
		log.info("### @PostConstruct ###");
		log.info("###");
	}
	
	
	public List<Dept> selectAll() {
		List<Dept> list = new ArrayList<>();
		
		list.add(new Dept(10,"xxx1","yyy1"));
		list.add(new Dept(20,"xxx2","yyy2"));
		
		return list;
		
	}
	
	@PreDestroy
	public void PreDestroy(){
		log.info("###");
		log.info("### @PreDestroy ###");
		log.info("###");
	}
	
	
}
