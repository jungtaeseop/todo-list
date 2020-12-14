package com.two.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface Todo_itemRepository extends CrudRepository<Todo_item, Long> {
//	Optional<Tb_item> findById(String id);
	

	
}
