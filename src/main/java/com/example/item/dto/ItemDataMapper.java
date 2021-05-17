package com.example.item.dto;

import com.example.brand.domain.Brand;
import com.example.brand.repository.BrandRepository;
import com.example.category.domain.Category;
import com.example.category.repository.CategoryRepository;
import com.example.exception.ResourceNotFoundException;
import com.example.item.domain.Item;
import com.example.persistence.mapper.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemDataMapper implements DtoMapper<ItemDto, Item> {

    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ItemDataMapper(BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Item toEntity(ItemDto itemDto) {
        var brand = brandRepository.findById(itemDto.getBrandId()).orElseThrow(() -> new ResourceNotFoundException(Brand.class, itemDto.getBrandId()));
        var category = categoryRepository.findById(itemDto.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException(Category.class, itemDto.getCategoryId()));
        var item = new Item(itemDto.getName(), category, brand, itemDto.getGeneral(), itemDto.getStatus());

        return item;
    }

    @Override
    public ItemDto toDto(Item item) {
        return null;
    }
}
