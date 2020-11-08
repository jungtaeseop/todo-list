package com.two.demo.controllertest;

import lombok.Data;

@Data
public class ProductVO {
	private String productName;
	private double productPrice;

	public ProductVO(String productName, double productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}
}
