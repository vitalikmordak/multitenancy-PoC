package com.vm.multitenancypoc.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class Post extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false)
	@Setter(value = AccessLevel.PROTECTED)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Comment> comments = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "industry_id")
	private Industry industry;

	public void addComment(Comment comment) {
		comments.add(comment);
	}

}
