package com.smedina.generic_store.persistence.repository;

import com.smedina.generic_store.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findFirstByEmail(String email);
}
