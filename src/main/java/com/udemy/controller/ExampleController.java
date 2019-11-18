package com.udemy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/example")
public class ExampleController {

	private static final String EXAMPLE2_VIEW = "example2";
	
	
	
	@GetMapping("/request")
	public ModelAndView request1(@RequestParam(name="nm",required=false) String name) {
		ModelAndView mov = new ModelAndView(EXAMPLE2_VIEW);
		mov.addObject("nm_in_model", name);
		return mov;
	}
	
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String name) {
		ModelAndView mov = new ModelAndView(EXAMPLE2_VIEW);
		mov.addObject("nm_in_model",name);
		return mov;
	}
}
