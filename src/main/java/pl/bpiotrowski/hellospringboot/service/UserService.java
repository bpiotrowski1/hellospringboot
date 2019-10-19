package pl.bpiotrowski.hellospringboot.service;

import org.springframework.stereotype.Service;
import pl.bpiotrowski.hellospringboot.entity.User;

import java.util.*;

@Service
public class UserService {

    private Map<String, User> users = new HashMap<>();

    public List<User> findAll() {
        return Collections.singletonList(findUser());
    }

    public User findUser() {
        User user = new User();
        user.setName("Jan");
        user.setLastName("Kowalski");

        return user;
    }

    public void saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        System.out.println("Saved user: " + user);
        users.put(user.getId(), user);
    }
}
