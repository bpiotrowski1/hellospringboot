package pl.bpiotrowski.hellospringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bpiotrowski.hellospringboot.entity.User;
import pl.bpiotrowski.hellospringboot.service.UserService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public Collection<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping
    @RequestMapping("/get")
    public User getUser() {
        return userService.findUser();
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }
}
