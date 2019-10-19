package pl.bpiotrowski.hellospringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bpiotrowski.hellospringboot.entity.User;
import pl.bpiotrowski.hellospringboot.service.UserService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public Collection<User> findAllUsers(@RequestParam(required = false, name = "sortOrder") String sort) {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.findUser(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        if(userService.findUser(user.getId()) != null) {
            deleteUser(user.getId());
        }
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
