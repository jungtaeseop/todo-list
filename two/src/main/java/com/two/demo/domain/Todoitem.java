package com.two.demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.two.demo.BaseTimeEntity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성
@Entity
@DynamicInsert  // DB에 default 값을 넣어주는 어노테이션  같이 써야된다
public class Todoitem extends BaseTimeEntity {
	@Id
	@Column(length = 200)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	
	@Column(length = 200, nullable = false) // nullable db에 null값 허용 안함
	private String work;
	
	@ColumnDefault("0")  // DB에 default 값을 넣어주는 어노테이션 
	private String completion;
	
	@Builder
	public void Todo_item(String work) {  //해당 값을 받아서 work에 넣어 주는 함수
		this.work=work;
	}


}
