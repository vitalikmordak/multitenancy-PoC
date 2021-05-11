package com.vm.multitenancypoc.infrastructure.aop;

import com.vm.multitenancypoc.util.TenantContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Aspect
@Component
public class TenantFilterAspect {

	@PersistenceContext
	public EntityManager entityManager;

	@Around(value = "Pointcuts.hasTenantAnnotation()")
	public Object aroundExecution(ProceedingJoinPoint pjp) throws Throwable {
		Long tenantId = TenantContext.getCurrentTenantId();
		if (tenantId == null) {
			throw new RuntimeException("Access Denied.");
		}

		org.hibernate.Filter filter = entityManager.unwrap(Session.class).enableFilter("tenantFilter");
		filter.setParameter("tenantId", tenantId);
		filter.validate();
		return pjp.proceed();
	}
}
