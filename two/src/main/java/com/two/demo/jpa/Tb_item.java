package com.two.demo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
public class Tb_item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userno;
	
	@Column(length = 20, nullable = false)
	private String id;
	private String password;
	private String user_name;
	private String cell_phone;
	private String email;
	
	public void Tb_item(String id,String password, String user_name,String cell_phone, String email) {
		this.id=id;
		this.password=password;
		this.user_name=user_name;
		this.cell_phone=cell_phone;
		this.email=email;
	}


}
