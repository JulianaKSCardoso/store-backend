package com.santana.java.backend.service;

import com.santana.java.backend.dto.UserDTO;
import com.santana.java.backend.model.User;
import com.santana.java.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(long userId) {
        Optional<User> usuario = userRepository.findById(userId);
        return usuario.map(UserDTO::convert).orElse(null);
    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(user);
    }

    public UserDTO delete(long userId) {
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(value -> userRepository.delete(value));
        return null;
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user != null) {
            return UserDTO.convert(user);
        }
        return null;
    }

    public List<UserDTO> queryByName(String name) {
        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }
}
