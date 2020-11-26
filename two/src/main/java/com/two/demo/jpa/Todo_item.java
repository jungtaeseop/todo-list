package com.two.demo.jpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.two.demo.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Todo_item extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer number;
	
	@Column(length = 20, nullable = false)
	private String work;
	private String completion;
	
	@Builder
	public void Todo_item(String work) {  //해당 값을 받아서 work에 넣어 주는 함수
		this.work=work;
	}


}
