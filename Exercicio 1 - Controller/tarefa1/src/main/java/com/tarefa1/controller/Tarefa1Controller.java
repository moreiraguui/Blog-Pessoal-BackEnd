package com.tarefa1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefa1")
public class Tarefa1Controller {
	
	@GetMapping
	public String tarefa1() {
		return "Utilizei a persistência, proatividade e mentalidade de crescimento.";
	}

}
