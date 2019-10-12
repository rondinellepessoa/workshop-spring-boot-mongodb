package com.rondinellepessoa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rondinellepessoa.domain.User;
import com.rondinellepessoa.dto.UserDTO;
import com.rondinellepessoa.repository.UserRepository;
import com.rondinellepessoa.services.exeception.ObjectNotFoundException;

/**
 * Responsavel pelo acesso ao banco de dados MongoDB 
 * @author Rondinelle
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(Integer id) {
		User user = repo.findById(id).orElse(null);
		if (user == null)
			throw new ObjectNotFoundException("Objeto nao encontrado.");
		return user;
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = repo.findById(user.getId()).orElse(null);
		update(newUser, user);
		return repo.save(newUser);
	}
	
	private void update(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
	
}
