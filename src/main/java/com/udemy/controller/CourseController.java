package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.entity.Course;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	private static final String COURSES_VIEW = "courses";
	
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
	@GetMapping("/list")
	public ModelAndView listAllCourse() {
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course",new Course());
		mav.addObject("courses", courseService.listAllCourse());
		return mav;
	}
	
	@PostMapping("/addcourse")
	 public String addCourse(@ModelAttribute("course") Course course)
	 {
		 courseService.addCourse(course);
		 return "redirect:/course/list";
	 }
	
}
