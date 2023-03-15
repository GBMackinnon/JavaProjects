package com.duncan.blog_root.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.duncan.blog_root.jpa.entity.Post;




/**
 * The Interface PostRepository.
 */
public interface PostRepository extends JpaRepository<Post, Long>
{

	/**
	 * Find by label.
	 *
	 * @param label the label
	 * @param sort  the sort
	 * @return the list
	 */
	List<Post> findByTitle(String title, Sort sort);

	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<Post> findAll(Pageable pageable);

	/**
	 * Find by label.
	 *
	 * @param label the label
	 * @return the list
	 */
	List<Post> findByTitle(String title);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	Optional<Post> findById(Long id);

}