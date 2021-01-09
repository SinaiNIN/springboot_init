package com.example.item.dto;

import com.example.brand.domain.Brand;
import com.example.brand.repository.BrandRepository;
import com.example.category.domain.Category;
import com.example.category.repository.CategoryRepository;
import com.example.exception.ResourceNotFoundException;
import com.example.item.domain.Item;
import com.example.persistence.mapper.DtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ItemDataMapper implements DtoMapper<ItemDto, Item> {

    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

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
