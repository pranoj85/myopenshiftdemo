package com.work.myopenshiftdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyopenshiftdemoApplication {

	@Value("${appColor:pink}")
	private String appColor;

	public static void main(String[] args) {
		SpringApplication.run(MyopenshiftdemoApplication.class, args);
	}

	@GetMapping("/openshift/demo")
	public ResponseEntity<String> showDemo() {
		return new ResponseEntity<String>(new String("This is my first openshift demo <H2 style='color:"+appColor+"'> Tesing app. </H2>"), HttpStatus.OK);
	}

	public String getAppColor() {
		return appColor;
	}

	public void setAppColor(String appColor) {
		this.appColor = appColor;
	}
}
