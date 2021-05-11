package com.vm.multitenancypoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vm.multitenancypoc.entity.tenant.Tenant;
import com.vm.multitenancypoc.util.TenantContext;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

@MappedSuperclass
@FilterDef(name = "tenantFilter", parameters = {@ParamDef(name = "tenantId", type = "long")})
@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")
@Getter @Setter
public abstract class BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id", updatable = false)
	@JsonIgnore
	private Tenant tenant;

	@PrePersist
	@PreUpdate
	@PreRemove
	public void onPrePersist() {
		this.tenant = TenantContext.getCurrentTenant();
	}
}
