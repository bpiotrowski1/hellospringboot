package pl.bpiotrowski.hellospringboot.service;

import org.springframework.stereotype.Service;
import pl.bpiotrowski.hellospringboot.entity.User;

import java.util.*;

@Service
public class UserService {

    private Map<String, User> users = new HashMap<>();

    public Collection<User> findAll() {
        return users.values();
    }

    public User findUser(String id) {
        return users.get(id);
    }

    public User saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        users.put(user.getId(), user);
        return user;
    }

    public void deleteUser(String id) {
        users.remove(id);
    }
}
