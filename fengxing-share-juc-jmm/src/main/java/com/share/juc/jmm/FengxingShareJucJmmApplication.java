package com.share.juc.jmm;

import com.share.juc.jmm.demo.Jmm01NoVolatile;
import com.share.juc.jmm.demo.Jmm04SingleInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FengxingShareJucJmmApplication {

	public static void main(String[] args) {
		//System.out.println("instance:"+ Jmm04SingleInstance.getInstance());
		SpringApplication.run(FengxingShareJucJmmApplication.class, args);
	}

}
