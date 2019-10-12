package com.rondinellepessoa.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rondinellepessoa.domain.User;
import com.rondinellepessoa.dto.UserDTO;
import com.rondinellepessoa.services.UserService;

/**
 * Responsavel por realizar o controle de requisicoes aos servicos
 * @author Rondinelle
 *
 */
@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}
}
