package com.udemy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("/say")
public class HelloController {

	public static final String EXAMPLE_VIEW ="hello";
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	@GetMapping("/hello")
	public String holamundo(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people",exampleService.getListpeople());
		return "hello";
	}
	
	// para insertar muchos datos
	@GetMapping("/helloMAV")
	public ModelAndView holaMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("person",new Person("Michael",30));
		return mav;
	}
	
	
	
	 //  video 32 - carpeta 05-curso spring mvc
}
