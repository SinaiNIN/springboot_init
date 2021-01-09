package com.example.brand.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandRepositoryWrapper {
    private final BrandRepository repository;

    @Autowired
    public BrandRepositoryWrapper(final BrandRepository repository) {
        this.repository = repository;
    }
}
