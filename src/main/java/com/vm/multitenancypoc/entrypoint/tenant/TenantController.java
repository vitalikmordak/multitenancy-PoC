package com.vm.multitenancypoc.entrypoint.tenant;

import com.vm.multitenancypoc.entity.tenant.Tenant;
import com.vm.multitenancypoc.service.tenant.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tenants")
@RequiredArgsConstructor
public class TenantController {

	private final TenantService tenantService;

	@PostMapping
	public Tenant create(@RequestBody Tenant tenant) {
		return tenantService.create(tenant);
	}
}
