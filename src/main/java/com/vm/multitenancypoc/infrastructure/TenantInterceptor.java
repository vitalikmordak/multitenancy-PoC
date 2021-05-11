package com.vm.multitenancypoc.infrastructure;

import com.vm.multitenancypoc.entity.tenant.Tenant;
import com.vm.multitenancypoc.service.tenant.TenantService;
import com.vm.multitenancypoc.util.TenantContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class TenantInterceptor implements HandlerInterceptor {

	private static final String TENANT_HEADER = "X-TenantID";

	private final TenantService tenantService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String tenantHeader = request.getHeader(TENANT_HEADER);
		if (!tenantHeader.isEmpty()) {
			Tenant tenant = tenantService.findByName(tenantHeader).orElseThrow(() -> new RuntimeException("tenants not found"));
			log.debug("Set TenantContext: {}", tenant);
			TenantContext.setCurrentTenant(tenant);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		log.debug("Clear TenantContext: {}", TenantContext.getCurrentTenant());
		TenantContext.clear();
	}
}
