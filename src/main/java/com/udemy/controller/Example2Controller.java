package com.udemy.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "result";
	
	// redireccion 1
	/*
	 * @GetMapping("/") public String redirect() { return "redirect:/example2/show";
	 * }
	 */
	
	@GetMapping("/")
	public RedirectView redirect1() {
		return new RedirectView("/example2/show");
	}
	
	@GetMapping("/show")
	public String showForm(Model model) {
		model.addAttribute("person",new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person,BindingResult bindingResult) {
		ModelAndView mov = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mov.setViewName(FORM_VIEW);
		}else {
			mov.setViewName(RESULT_VIEW);
			mov.addObject("person", person);
		}
		
		return mov;
	}
	
}
