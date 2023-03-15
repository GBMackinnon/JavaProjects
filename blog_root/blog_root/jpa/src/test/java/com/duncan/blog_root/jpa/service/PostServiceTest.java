package com.duncan.blog_root.jpa.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.duncan.blog_root.jpa.entity.Post;

@SpringBootTest
class PostServiceTest
{
	@Autowired
	private PostService postService;

	/**
	 * Creates the post 1 test.
	 */
	@Test
	void createPost1Test()
	{

		// DataSource created
		Assertions.assertNotNull(postService);

		Post post = new Post("title1", "description1", "content1");
		
		List<Post> postList = postService.getAllPosts();
		
		Post createdPost = postService.createPost(post);
		Assertions.assertNotNull(createdPost);

	}

	@Test
	void createPost2Test()
	{

		// DataSource created
		Assertions.assertNotNull(postService);

		Post post = new Post("title2", "description2", "content2");

		Post createdPost = postService.createPost(post);
		Assertions.assertNotNull(createdPost);

	}

}
