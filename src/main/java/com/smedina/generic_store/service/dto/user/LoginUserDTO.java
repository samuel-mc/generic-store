package com.smedina.generic_store.service.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginUserDTO {
    private String email;
    private String password;
}
