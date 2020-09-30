package com.cg.healthcaresystem.diagnosticcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * this is equal to three annotations 1) @Configuration 2)@ComponentScan
 * 3)@EnableAutoConfiguration
 */
@SpringBootApplication
@EnableTransactionManagement
public class CenterManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(CenterManagementApplication.class, args);
	
	}


@Bean
public RestTemplate restTemplate(){
	RestTemplate restTemplate=new RestTemplate();
	return restTemplate;
}





	
  @Bean public CorsFilter corsFilter()
  { UrlBasedCorsConfigurationSource src=new
  UrlBasedCorsConfigurationSource(); CorsConfiguration configuration=new
  CorsConfiguration(); configuration.setAllowCredentials(true);
  configuration.addAllowedHeader("*"); configuration.addAllowedOrigin("*");
  configuration.addAllowedMethod("*");
  src.registerCorsConfiguration("/**",configuration); return new
 CorsFilter(src); } }
 
