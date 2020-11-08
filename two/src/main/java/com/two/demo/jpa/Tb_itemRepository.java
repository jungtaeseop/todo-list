package com.two.demo.jpa;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface Tb_itemRepository extends CrudRepository<Tb_item, Long> {
//	Optional<Tb_item> findById(String id);
	
}
