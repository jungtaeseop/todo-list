package com.two.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.two.demo.domain.Todoitem;
import com.two.demo.domain.todoDto;
import com.two.demo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;

	@Autowired
	private todoDto tododto;

	@GetMapping("/home")
	public String getItemPage() {
		return "home";
	}

	@PostMapping(path = "/add") // 해당 url을 호출하면 함수가 실행 되는 곳
	@ResponseBody
	public String addTodo(@RequestBody Todoitem todoitem) { // @RequestBody : HTTP POST 요청에 대해서만 처리 and request body에
																// 있는 request message에서 값을 얻어와 매칭한다.
//		log.info(Todoitem.getWork());
//		System.out.println(Todoitem.getWork());
//		Todoitem n = new Todoitem();
//		n.Todoitem(Todoitem.getWork());
//		TodoitemRepository.save(n);  해당 값만 넣어서 가능 두번 작업
		
		todoService.join(todoitem);
		
		return "Saved";
	}

	@DeleteMapping(path = "/delete")
	@ResponseBody
	public String deleteTodo(@RequestBody todoDto Todoitem) { // Todoitem 값을 number 값만 삭제 가능
		Todoitem.getIdx().stream().forEach(i -> {
			System.out.println("i = " + i);
		});
		tododto.setIdx(Todoitem.getIdx());
		System.out.println(Todoitem);
		return "delete";
	}

//	@PutMapping(path = "update")
//	@ResponseBody
//	public String updateTodo(@RequestBody Todoitem Todoitem) {
//
//		todoService.save(Todoitem);
//		return "put";
//	}

//  @DeleteMappin(path = "/delete")
//  @ResponseBody
//  public String deleteTodo(@RequestBody Todoitem Todoitem) {
//	  
//	  
//    TodoitemRepository.deleteAll();
//    return "deleteAll";
//  }

	@GetMapping(path = "/all")
	@ResponseBody
	public Iterable<Todoitem> getAllUsers() {

		return todoService.findMembers();
	}
}
