package com.tarefa1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefa2")
public class Tarefa2Controller {
	
	@GetMapping
	public String tarefa2() {
		return "Para essa semana eu pretendo aprender sobre Spring Boot.";
	}

}
