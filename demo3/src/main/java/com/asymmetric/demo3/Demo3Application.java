package com.asymmetric.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Demo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}
	
	//agregado en vez de @CrossOrigin
	//@Configuration
	//@EnableWebMvc
	//public class WebConfig implements WebMvcConfigurer {
	// 
	//    @Override
	//    public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/**");
//	    }
//	}
}
