package com.example.user.authentication.repository;

import com.example.user.authentication.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query(value = "SELECT u FROM AppUser u WHERE u.userName = ?1")
    Optional<AppUser> findByUserName(final String userName);
}
