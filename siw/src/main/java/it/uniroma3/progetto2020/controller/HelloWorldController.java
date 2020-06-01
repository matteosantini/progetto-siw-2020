package it.uniroma3.progetto2020.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping(value= "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello World!";
	}
	
}
