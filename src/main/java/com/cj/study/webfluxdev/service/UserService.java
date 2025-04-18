package com.cj.study.webfluxdev.service;

import com.cj.study.webfluxdev.model.User;
import com.cj.study.webfluxdev.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public Mono<User> getUser(Long id) {
        return repo.findById(id);
    }

    public Flux<User> getUsers() {
        return repo.findAll();
    }

    public Mono<User> createUser(User user) {
        return repo.save(user);
    }
}
