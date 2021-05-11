package com.vm.multitenancypoc.util;

import com.vm.multitenancypoc.entity.tenant.Tenant;

public class TenantContext {

	private static ThreadLocal<Tenant> currentTenant = new ThreadLocal<>();

	public static Tenant getCurrentTenant() {
		return currentTenant.get();
	}

	public static Long getCurrentTenantId() {
		return currentTenant.get() == null ? null : currentTenant.get().getId();
	}

	public static void setCurrentTenant(Tenant tenant) {
		currentTenant.set(tenant);
	}

	public static void clear() {
		currentTenant.set(null);
	}
}
