package com.two.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.demo.domain.Todoitem;
import com.two.demo.repository.TodoRepository;

@Transactional
public class TodoService {
	private final TodoRepository todoRepository;
	
	@Autowired
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public Long join(Todoitem todoitem) {
		validateDuplicatetodoitem(todoitem);
		todoRepository.save(todoitem);
		return todoitem.getId();
	}
	
	private void validateDuplicatetodoitem(Todoitem todoitem) {
		Optional<Todoitem> result =  todoRepository.findByWork(todoitem.getWork());
		result.ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원");
		});
	}
	
	public List<Todoitem> findMembers(){
		return todoRepository.findAll();
	}
	
	public Optional<Todoitem> findOne(Long todoId){
		return todoRepository.findById(todoId);
		
	}

}
