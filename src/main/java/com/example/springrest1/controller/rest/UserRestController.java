package com.example.springrest1.controller.rest;

import com.example.springrest1.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserRestController {

    private final List<User> users = new ArrayList<>();

    {
        users.add(new User(1L, "Александр"));
        users.add(new User(2L, "Даниил"));
        users.add(new User(3L, "Никита"));
        users.add(new User(4L, "Сергей"));
    }

    @GetMapping(value = "/")
    public List<User> findAllUsers() { return users; }

    @GetMapping(value = "/{id}")
    public User findUserById (@PathVariable Long id) {
        return users.stream().filter(it -> it.getId().equals(id)).findFirst().orElseThrow(() ->
                new NoResultException("Пользователь с указанным id (" + id + ") не существует!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/")
    public void addUser(User user) {
        users.add(user);
    }

    @GetMapping(value = "/delete/{id}")
    public void deleteUserById (@PathVariable Long id) {
        users.removeIf(it -> it.getId().equals(id));
    }
}
