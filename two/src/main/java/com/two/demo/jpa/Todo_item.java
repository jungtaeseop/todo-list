package com.two.demo.jpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.two.demo.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성
@Entity
@DynamicInsert  // DB에 default 값을 넣어주는 어노테이션  같이 써야된다
public class Todo_item extends BaseTimeEntity {
	@Id
	@GeneratedValue
	private Integer number;
	
	@Column(length = 100, nullable = false) // nullable db에 null값 허용 안함
	private String work;
	
	@ColumnDefault("0")  // DB에 default 값을 넣어주는 어노테이션 
	private String completion;
	
	@Builder
	public void Todo_item(String work) {  //해당 값을 받아서 work에 넣어 주는 함수
		this.work=work;
	}


}
