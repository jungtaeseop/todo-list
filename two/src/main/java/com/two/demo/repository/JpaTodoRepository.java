package com.two.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.two.demo.domain.Todoitem;

public class JpaTodoRepository implements TodoRepository{
	
	private final EntityManager em;
	
	public JpaTodoRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Todoitem save(Todoitem todoitem) {
		em.persist(todoitem);
		return todoitem;
	}

	@Override
	public Optional<Todoitem> findById(Long id) {
		Todoitem todoitem = em.find(Todoitem.class, id);
		return Optional.ofNullable(todoitem);
	}

	@Override
	public Optional<Todoitem> findByWork(String work) {
		List<Todoitem> result = em.createQuery("select m from Todoitem m where m.work = :work",Todoitem.class)
				.setParameter("work", work)
				.getResultList();
		return result.stream().findAny();
	}

	@Override
	public List<Todoitem> findAll() {
		List<Todoitem> result = em.createQuery("select m from Todoitem m",Todoitem.class)
				.getResultList();
		return result;
	}

}
