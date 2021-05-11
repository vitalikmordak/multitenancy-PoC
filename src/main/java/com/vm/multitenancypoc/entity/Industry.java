package com.vm.multitenancypoc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "industries")
@Data
@NoArgsConstructor
public class Industry extends BaseEntity {
	@Id
	@GeneratedValue
	private long id;

	@Column(name = "name")
	private String name;
}
