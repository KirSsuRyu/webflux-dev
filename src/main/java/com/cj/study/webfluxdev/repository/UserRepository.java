package com.cj.study.webfluxdev.repository;

import com.cj.study.webfluxdev.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}