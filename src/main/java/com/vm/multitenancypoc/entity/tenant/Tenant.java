package com.vm.multitenancypoc.entity.tenant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tenants")
@NoArgsConstructor
@Data
public class Tenant {

	@Id
	@GeneratedValue
	@Column(name = "tenant_id", updatable = false)
	@JsonIgnore
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "city")
	private String city;
}
