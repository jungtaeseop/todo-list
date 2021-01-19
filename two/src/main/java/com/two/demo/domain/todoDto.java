package com.two.demo.domain;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class todoDto {
	private List<Integer> idx;
	private List<String> work;
	
	private List<String> completion;
	
	
	
	
}
