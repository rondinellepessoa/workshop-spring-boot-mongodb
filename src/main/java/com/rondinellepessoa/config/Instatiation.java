package com.rondinellepessoa.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rondinellepessoa.domain.Post;
import com.rondinellepessoa.domain.User;
import com.rondinellepessoa.dto.AuthorDTO;
import com.rondinellepessoa.dto.CommentDTO;
import com.rondinellepessoa.repository.PostRepository;
import com.rondinellepessoa.repository.UserRepository;

/**
 * Classe responsavel por popular o banco de dados MongoDB
 * @author Rondinelle
 *
 */
@Configuration
public class Instatiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GT"));

		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(1L, "Maria Brown", "maria@gmail.com");
		User alex = new User(2L, "Alex Green", "alex@gmail.com");
		User bob = new User(3L, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(1L, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Portugal, abraços!", new AuthorDTO(maria));
		Post post2 = new Post(2L, sdf.parse("21/03/2018"), "Bom dia", "Acordei feliz hojes!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
