package com.rondinellepessoa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rondinellepessoa.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, Integer>{

}
