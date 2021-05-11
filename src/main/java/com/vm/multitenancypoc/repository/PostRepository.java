package com.vm.multitenancypoc.repository;

import com.vm.multitenancypoc.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
