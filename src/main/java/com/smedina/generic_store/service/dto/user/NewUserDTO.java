package com.smedina.generic_store.service.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewUserDTO extends UserDTO{
    private String password;
}
