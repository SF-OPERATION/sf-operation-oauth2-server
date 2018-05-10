package com.sf.operation.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PublicController {

	@GetMapping("/public")
	public String home(){
		System.out.println("Public content working!!!");
		return "This is public content.";
	}
}
