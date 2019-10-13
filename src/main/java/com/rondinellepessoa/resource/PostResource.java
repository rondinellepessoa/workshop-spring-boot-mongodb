
package com.rondinellepessoa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rondinellepessoa.domain.Post;
import com.rondinellepessoa.services.PostService;

/**
 * Responsavel por realizar o controle de requisicoes aos servicos
 * 
 * @author Rondinelle
 *
 */
@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable Integer id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
}
