package com.example.user.authentication.domain;

import com.example.persistence.VersionedEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@Table(name = "tbl_user")
public class AppUser extends VersionedEntity {
    @NotNull
    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Email
    private String email;

    private String mobile;

    @NotNull
    @Column(nullable = false)
    private String password;
}
