package com.two.demo.jpa;

import org.springframework.data.repository.CrudRepository;

public interface Todo_itemRepository extends CrudRepository<Todo_item, Long> {
//	Optional<Tb_item> findById(String id);
	
}
