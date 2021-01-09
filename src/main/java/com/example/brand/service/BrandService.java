package com.example.brand.service;

import com.example.brand.domain.Brand;
import com.example.brand.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService {
    private final BrandRepository repository;

    public List<Brand> getBrand() {
        return repository.findAll();
    }

}
