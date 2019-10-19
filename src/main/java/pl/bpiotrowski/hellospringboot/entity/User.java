package pl.bpiotrowski.hellospringboot.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String lastName;
}
