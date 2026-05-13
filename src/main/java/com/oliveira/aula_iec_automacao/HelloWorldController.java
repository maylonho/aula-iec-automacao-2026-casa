package com.oliveira.aula_iec_automacao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/hello")
	public String hello() {
		return "Teste do endpoint Gello World";
	}
}
