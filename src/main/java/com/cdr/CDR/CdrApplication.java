package com.cdr.CDR;

import com.cdr.CDR.mapper.DataMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CdrApplication {

	public static void main(String[] args) {
		DataMapper.loadProperties();
		SpringApplication.run(CdrApplication.class, args);
	}

}
