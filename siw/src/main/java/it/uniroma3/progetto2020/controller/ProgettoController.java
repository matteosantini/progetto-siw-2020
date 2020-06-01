package it.uniroma3.progetto2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.progetto2020.service.ProjectService;

@Controller
@RequestMapping("/progetto")
public class ProgettoController {

	@Autowired
	private ProjectService progettoService;
	
	
}
