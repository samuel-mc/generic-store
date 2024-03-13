package com.smedina.generic_store.service.mapper;

import com.smedina.generic_store.persistence.entity.UserEntity;
import com.smedina.generic_store.service.dto.user.NewUserDTO;
import com.smedina.generic_store.service.dto.user.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity newUserDTOToUserEntity(NewUserDTO newUserDTO);

    UserDTO userEntityToUserDTO(UserEntity userEntity);
}
