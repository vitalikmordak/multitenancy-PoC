package com.vm.multitenancypoc.entrypoint;

import com.vm.multitenancypoc.entity.Comment;
import com.vm.multitenancypoc.entity.Post;
import com.vm.multitenancypoc.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@PostMapping
	public Post create(@RequestBody Post post) {
		return postService.create(post);
	}

	@GetMapping
	public List<Post> getAll() {
		return postService.getAll();
	}

	@GetMapping("{id}")
	public Post getPostById(@PathVariable Long id) {
		return postService.getById(id);
	}

	@PostMapping("{id}/comments")
	public Post addComment(@PathVariable Long id, @RequestBody Comment comment) {
		return postService.addComment(id, comment);
	}
}
