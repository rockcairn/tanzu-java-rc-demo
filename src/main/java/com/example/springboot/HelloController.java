package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Rockcairn: Greetings from Spring Boot + Tanzu! <ul><li><a href=\"mountain\"/></li><li><a href=\"trip\"/></li></ul>";
	}

	@RequestMapping("/mountain")
	public String mountain() {
		return "Rockcairn: Capital Peak!";
	}

	@RequestMapping("/trip")
	public String trip() {
		return "Rockcairn: Alaska!";
	}

}