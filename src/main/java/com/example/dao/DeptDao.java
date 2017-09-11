package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.Dept;

import lombok.extern.java.Log;

@Component				// Spring Annotation 하위 패키지 경로내에서 @Component설정되어있는 Class를 Bean객체로 등록한다.
@Log					// Lombok Annotation 
public class DeptDao implements InitializingBean, DisposableBean {
	
	
	public DeptDao(){
		log.info("###");
		log.info("### 1. DeptDao() ..... ###");
		log.info("###");
	}
	

	Dept dept;
	// Injection 
	// 1. 생성자 주입 ( Constructor Injection )
	// 2. 세터 주입 ( Setter Injection )
	// 3. 필드 주입 (Field Injection )
	
	
	@Autowired			// Setter Injection
	public void setDept(Dept dept){
		log.info("###");
		log.info("### 2. setDept() ..... ###");
		log.info("###");
		log.info("### " + dept);
		log.info("###");
		this.dept = dept;
	}
	
	@PostConstruct
	public void PostConstruct() {
		log.info("^_____________________________^");
		log.info("### 3. @PostConstruct ###");
		log.info("^_____________________________^");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		log.info("### 4. implements InitializingBean afterPropertiesSet() ###");
		log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		
	}
	
	@Autowired			// 필드주입
	DataSource ds;
	
	public List<Dept> selectAll() throws SQLException {
		List<Dept> list = new ArrayList<>();
		
//		list.add(new Dept(10,"xxx1","yyy1"));
//		list.add(new Dept(20,"xxx2","yyy2"));
		
		Connection con = ds.getConnection(); 
		PreparedStatement pstmt = con.prepareStatement("select name from city");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			list.add(new Dept(10,rs.getString("name"),"yyy"));
		}
		
		
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
		
	}
	
	@PreDestroy
	public void PreDestroy(){
		log.info("###");
		log.info("### @PreDestroy ###");
		log.info("###");
	}

	@Override
	public void destroy() throws Exception {
		log.info("++++++++++++++++++++++++++++++++++++++++++");
		log.info("++++ DispoableBean.destroy()....");
		log.info("++++++++++++++++++++++++++++++++++++++++++");
	}

	
	
}
