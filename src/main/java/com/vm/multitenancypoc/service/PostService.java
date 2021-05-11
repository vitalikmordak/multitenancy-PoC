package com.vm.multitenancypoc.service;

import com.vm.multitenancypoc.entity.Comment;
import com.vm.multitenancypoc.entity.Post;
import com.vm.multitenancypoc.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	@Transactional
	public Post create(Post post) {
		return postRepository.save(post);
	}

	public List<Post> getAll() {
		List<Post> all = postRepository.getAll();
		return all;
	}

	public Post getById(Long postId) {
		return postRepository.getById(postId).orElseThrow(() -> new RuntimeException("post not found"));
	}

	@Transactional
	public Post addComment(Long postId, Comment comment) {
		Post post = postRepository.getById(postId).orElseThrow(() -> new RuntimeException("post not found"));
		post.addComment(comment);
		return postRepository.save(post);
	}
}
