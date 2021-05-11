package com.vm.multitenancypoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
public class Comment extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false)
	@JsonIgnore
	private long id;

	@Column(name = "message")
	private String message;

}
