package com.two.demo.todolist;

import com.two.demo.jpa.Todo_item;
import com.two.demo.jpa.Todo_itemRepository;

import lombok.extern.slf4j.Slf4j;

import java.io.Console;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class todoController {

	@Autowired
	private Todo_itemRepository todo_itemRepository;

	@GetMapping("/home")
	public String getItemPage() {
		return "home";
	}

	@PostMapping(path = "/add") // 해당 url을 호출하면 함수가 실행 되는 곳
	@ResponseBody
	public String addTodo(@RequestBody Todo_item todo_item) { // @RequestBody : HTTP POST 요청에 대해서만 처리 and request body에
																// 있는 request message에서 값을 얻어와 매칭한다.
//		log.info(todo_item.getWork());
//		System.out.println(todo_item.getWork());
//		Todo_item n = new Todo_item();
//		n.Todo_item(todo_item.getWork());
//		todo_itemRepository.save(n);  해당 값만 넣어서 가능 두번 작업
		todo_itemRepository.save(todo_item);
		return "Saved";
	}

	@DeleteMapping(path = "/delete")
	@ResponseBody
	public String deleteTodo(@RequestBody Todo_item todo_item) {  // todo_item 값을 number 값만 삭제 가능
		
		todo_itemRepository.delete(todo_item);
		return "delete";
	}
	
	
	@PutMapping(path = "update")
	@ResponseBody
	public String updateTodo(@RequestBody Todo_item todo_item ) {
		
		todo_itemRepository.save(todo_item);
		return "put";
	}
	
//  @DeleteMappin(path = "/delete")
//  @ResponseBody
//  public String deleteTodo(@RequestBody Todo_item todo_item) {
//	  
//	  
//    todo_itemRepository.deleteAll();
//    return "deleteAll";
//  }

	@GetMapping(path = "/all")
	@ResponseBody
	public Iterable<Todo_item> getAllUsers() {

		return todo_itemRepository.findAll();
	}
}
