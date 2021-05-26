package com.example.user.authentication.service;


import com.example.user.authentication.domain.AppUser;
import com.example.user.authentication.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService {

    private AppUserRepository appUserRepository;

    public Optional<AppUser> getByUserName(String name){
        return appUserRepository.findByUserName(name);
    }

}
