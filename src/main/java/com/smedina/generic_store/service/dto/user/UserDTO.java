package com.smedina.generic_store.service.dto.user;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
        private UUID id;
        private String name;
        private String lastName1;
        private String lastName2;
        private String email;

}