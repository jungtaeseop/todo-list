package com.two.demo.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Controller
public class MainController {
//	@Autowired
//	private Tb_itemRepository tb_itemRepository;
//	
//	
//	@GetMapping("/home")
//	public String getItemPage() {
//		return "home";
//	}
//	
//	@PostMapping(path="/add")
//	@ResponseBody
//	public String addNewUser (@RequestBody Tb_item tb_item) {
//		Tb_item n = new Tb_item();
//	    n.Tb_item(tb_item.getId(),tb_item.getPassword(),tb_item.getUser_name(),tb_item.getCell_phone(),tb_item.getEmail());
//	    tb_itemRepository.save(n);
//	    return "Saved";
//	}
//	
//	@GetMapping(path="/all")
//	@ResponseBody
//	  public Iterable<Tb_item> getAllUsers() {
//	    // This returns a JSON or XML with the users
//	    return tb_itemRepository.findAll();
//	  }

}
