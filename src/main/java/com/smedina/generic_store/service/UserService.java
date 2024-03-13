package com.smedina.generic_store.service;

import com.smedina.generic_store.persistence.entity.UserEntity;
import com.smedina.generic_store.persistence.repository.UserRepository;
import com.smedina.generic_store.service.dto.user.LoginUserDTO;
import com.smedina.generic_store.service.dto.user.NewUserDTO;
import com.smedina.generic_store.service.dto.user.UserDTO;
import com.smedina.generic_store.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

    public UserDTO createUser(NewUserDTO newUser) {
        try {
            // Map the NewUserDTO to a UserEntity
            UserEntity newUserEntity = userMapper.newUserDTOToUserEntity(newUser);

            // Encode the password
            String encodedPassword = encodePassword(newUser.getPassword());
            newUserEntity.setPassword(encodedPassword);

            // Save the user
            UserEntity userCreated = userRepository.save(newUserEntity);
            return userMapper.userEntityToUserDTO(userCreated);
        } catch (DataIntegrityViolationException e) {
            logger.error("Error creating user: Duplicate user found", e.getMessage());
            throw new RuntimeException("El correo ya está registrado");
        } catch (Exception e) {
            logger.error("Error creating user", e);
            throw new RuntimeException("Error creating user");
        }
    }

    public String login (LoginUserDTO loginUser) {
        UserEntity user = userRepository.findFirstByEmail(loginUser.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    }

    private String encodePassword(String password) {
        // Create an encoder with strength 16
        return encoder.encode("myPassword");
    }
}
