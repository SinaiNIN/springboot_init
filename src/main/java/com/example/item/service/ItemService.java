package com.example.item.service;

import com.example.exception.ResourceNotFoundException;
import com.example.item.domain.Item;
import com.example.item.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(final Long id, final Item item) {
        itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Item.class, id));
        return itemRepository.saveAndFlush(item);
    }

    public Optional<Item> getById(final Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> getAllUsers() {
        return itemRepository.findAll();
    }
}
