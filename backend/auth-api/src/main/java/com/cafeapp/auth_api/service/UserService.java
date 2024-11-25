package com.cafeapp.auth_api.service;

import com.cafeapp.auth_api.dto.UserLoginDTO;
import com.cafeapp.auth_api.dto.UserRegisterDTO;
import com.cafeapp.auth_api.entity.UserEntity;
import com.cafeapp.auth_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void register(UserRegisterDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email já registrado.");
        }
        UserEntity user = new UserEntity();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
    }

    public UserEntity authenticate(UserLoginDTO dto) {
        UserEntity user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        if (!new BCryptPasswordEncoder().matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Senha inválida.");
        }
        return user;
    }
}