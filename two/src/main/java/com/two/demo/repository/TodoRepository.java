package com.two.demo.repository;

import java.util.List;
import java.util.Optional;

import com.two.demo.domain.Todoitem;

public interface TodoRepository {
	Todoitem save(Todoitem todoitem);
	Optional<Todoitem> findById(Long id);
    Optional<Todoitem> findByWork(String work);
    List<Todoitem> findAll();

}
