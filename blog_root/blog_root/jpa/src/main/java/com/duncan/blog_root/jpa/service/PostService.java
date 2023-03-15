package com.duncan.blog_root.jpa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.duncan.blog_root.jpa.entity.Post;
import com.duncan.blog_root.jpa.repository.PostRepository;



/**
 * The Class PostService used to access repository.
 */
@Service
public class PostService
{

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(PostService.class);

	/** The repository. */
	@Autowired
	private PostRepository postRepository;

	/** The model mapper. */
	//@Autowired
	//private ModelMapper modelMapper;
	


	/**
	 * Save.
	 *
	 * @param post_DTO the post DTO
	 * @return the post DTO
	 */
	public Post createPost(Post post)
	{
		LOGGER.info("createPost() : " + post.toString());
		Post createdPost = postRepository.save(post);
		return createdPost;
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Post> getAllPosts()
	{
		List<Post> posts = postRepository.findAll();

		return posts;
	}
	


}