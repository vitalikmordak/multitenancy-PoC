package com.vm.multitenancypoc.repository;

import com.vm.multitenancypoc.entity.Post;
import com.vm.multitenancypoc.infrastructure.aop.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

	@Query("from Post p join fetch Industry i on p.industry.id = i.id")
	@Tenant
	List<Post> getAll();

	@Tenant
	Optional<Post> getById(Long id);
}
