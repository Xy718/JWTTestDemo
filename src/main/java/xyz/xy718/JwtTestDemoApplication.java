package xyz.xy718;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"xyz.xy718.*"})  //指定扫描包路径
public class JwtTestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTestDemoApplication.class, args);
	}

}