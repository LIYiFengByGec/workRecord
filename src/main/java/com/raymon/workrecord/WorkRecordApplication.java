package com.raymon.workrecord;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.raymon.workrecord.dao")
public class WorkRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkRecordApplication.class, args);
	}

}
