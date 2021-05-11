package com.vm.multitenancypoc.infrastructure.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

	@Pointcut(value = "@within(com.vm.multitenancypoc.infrastructure.aop.Tenant) || @annotation(com.vm.multitenancypoc.infrastructure.aop.Tenant)")
	void hasTenantAnnotation() {}
}
