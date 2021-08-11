package com.santana.java.backend.controller;

import com.santana.java.backend.dto.UserDTO;
import com.santana.java.backend.model.*;
import com.santana.java.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/")
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping("/users/cpf/{cpf}")
    UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @DeleteMapping("/user/{id}")
    UserDTO delete(@PathVariable long id) {
        return userService.delete(id);
    }

    @GetMapping("user/search")
    public List<UserDTO> queryByName(@RequestParam(name="nome", required = true) String nome) {
        return userService.queryByName(nome);
    }

}
