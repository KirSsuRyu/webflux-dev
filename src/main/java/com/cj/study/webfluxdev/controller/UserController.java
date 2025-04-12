package com.cj.study.webfluxdev.controller;


import com.cj.study.webfluxdev.model.User;
import com.cj.study.webfluxdev.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> getUser(@PathVariable Long id) {
        return service.getUser(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<User>> createUser(@RequestBody User user) {
        return service.createUser(user)
                .map(ResponseEntity::ok);
    }
}
