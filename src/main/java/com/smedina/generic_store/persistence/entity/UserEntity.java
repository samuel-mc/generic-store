package com.smedina.generic_store.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "last_name1", nullable = false, length = 100)
    private String lastName1;

    @Column(name = "last_name2", nullable = false, length = 100)
    private String lastName2;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;
}
