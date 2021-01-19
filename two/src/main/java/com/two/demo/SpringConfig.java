package com.two.demo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.two.demo.repository.JpaTodoRepository;
import com.two.demo.repository.TodoRepository;
import com.two.demo.service.TodoService;

@Configuration
public class SpringConfig {
	private EntityManager em;
	
	@Autowired
	public SpringConfig(EntityManager em) {
		this.em = em;
	}
	
	@Bean
	public TodoService todoService() {
		return new TodoService(todoRepository());
	}
	
	@Bean
	public TodoRepository todoRepository() {
		return new JpaTodoRepository(em);
	}
}
