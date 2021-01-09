package com.example.item.service;

import com.example.brand.domain.Brand;
import com.example.brand.repository.BrandRepository;
import com.example.category.domain.Category;
import com.example.category.repository.CategoryRepository;
import com.example.exception.ResourceNotFoundException;
import com.example.item.domain.Item;
import com.example.item.dto.ItemDataMapper;
import com.example.item.dto.ItemDto;
import com.example.item.repository.ItemRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ItemServiceTest {
    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemService itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void itShoutGetItemById() {
        Brand brand = new Brand("LG");
        Category category = new Category("Appliance", null);
        Item item = new Item("Fridge", category, brand, "{Price:1000$}", Boolean.TRUE);

        given(itemService.getById(anyLong())).willReturn(Optional.of(item));
        itemService.getById(anyLong());
        verify(itemRepository).findById(anyLong());
    }

    @Test
    void itShouldCreateItem() {
        Brand brand = new Brand("LG");
        Category category = new Category("Appliance", null);
        Item item = new Item("Fridge", category, brand, "{Price:1000$}", Boolean.TRUE);

        when(itemRepository.save(any(Item.class))).thenReturn(item);
        var itemResult = itemService.createItem(item);
        verify(itemRepository).save(item);

        assertThat(itemResult.getName()).isEqualTo("Fridge");
        assertThat(itemResult.getBrandId().getName()).isEqualTo("LG");
        assertThat(itemResult.getCategoryId().getName()).isEqualTo("Appliance");
        assertThat(itemResult.getStatus()).isTrue();
    }


    @Test
    void itShouldUpdateItem() {
        Brand brand = new Brand("LG");
        Category category = new Category("Home Appliance", null);
        Item item = new Item("LG TV L800", category, brand, "{Price:1000$}", Boolean.TRUE);

        when(itemRepository.findById(anyLong())).thenReturn(Optional.of(item));
        when(itemRepository.saveAndFlush(any(Item.class))).thenReturn(item);

        itemService.updateItem(Long.valueOf(1), item);
        verify(itemRepository).saveAndFlush(item);
    }

    @Test
    void itShoutNotUpdateItem() {
        Brand brand = new Brand("LG");
        Category category = new Category("Home Appliance", null);
        Item item = new Item("LG TV L800", category, brand, "{Price:1000$}", Boolean.TRUE);

        given(itemRepository.findById(anyLong())).willReturn(Optional.empty());
        assertThatThrownBy(() -> itemService.updateItem(Long.valueOf(1), eq(item)))
                .isInstanceOf(ResourceNotFoundException.class);
        verify(itemRepository).findById(anyLong());

    }

    @Test
    void itShoutGetAllUsers() {
        Brand brand = new Brand("LG");
        Category category = new Category("Home Appliance", null);
        Item item = new Item("LG TV L800", category, brand, "{Price:1000$}", Boolean.TRUE);
        var itemList = List.of(item);

        given(itemService.getAllUsers()).willReturn(itemList);
        itemService.getAllUsers();
        verify(itemRepository).findAll();
    }
}