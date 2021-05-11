package com.vm.multitenancypoc.service.tenant;

import com.vm.multitenancypoc.entity.tenant.Tenant;
import com.vm.multitenancypoc.repository.tenant.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TenantService {

	private final TenantRepository tenantRepository;

	@Transactional
	public Tenant create(Tenant tenant) {
		return tenantRepository.save(tenant);
	}

	public List<Tenant> getAll() {
		return tenantRepository.findAll();
	}

	public Optional<Tenant> findByName(String name) {
		return tenantRepository.findByName(name);
	}
}
