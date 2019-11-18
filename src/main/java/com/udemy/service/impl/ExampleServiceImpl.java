package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	@Override
	public List<Person> getListpeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Jhon",23));
		people.add(new Person("Eva",23));
		people.add(new Person("Mikel",23));
		people.add(new Person("Peter",23));
		
		return people;
	}
	
	
}
