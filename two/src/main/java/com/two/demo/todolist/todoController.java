package com.two.demo.todolist;


import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.two.demo.jpa.Todo_item;
import com.two.demo.jpa.Todo_itemRepository;

@Controller
public class todoController {
	@Autowired
	private Todo_itemRepository todo_itemRepository;
	
	
	@GetMapping("/home")
	public String getItemPage() {
		return "home";
	}
	
	@PostMapping(path="/add")
	@ResponseBody
	public String addTodo(@RequestBody Todo_item todo_item) {
		Todo_item n = new Todo_item();
	    n.Todo_item(todo_item.getWork());
	    todo_itemRepository.save(n);
	    return "Saved";
	}
	
	
//	@GetMapping(path="/all")
//	@ResponseBody
//	  public Iterable<Tb_item> getAllUsers() {
//	    // This returns a JSON or XML with the users
//	    return tb_itemRepository.findAll();
//	  }

}
