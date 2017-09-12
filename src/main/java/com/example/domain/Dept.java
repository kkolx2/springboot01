package com.example.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {


	int deptno;
	String dname;
	String loc;
	
}

