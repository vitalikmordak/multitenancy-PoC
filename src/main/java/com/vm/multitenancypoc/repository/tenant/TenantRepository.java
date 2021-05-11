package com.vm.multitenancypoc.repository.tenant;

import com.vm.multitenancypoc.entity.tenant.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

	Optional<Tenant> findByName(String  name);
}
