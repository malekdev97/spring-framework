package com.backend.backend.services;

import com.backend.backend.entities.ItemEntity;
import com.backend.backend.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemEntity> findAll() {
        return itemRepository.findAll();
    }

    public ItemEntity findById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Item not found with id: " + id));
    }

    public ItemEntity save(ItemEntity itemEntity) {
        itemRepository.save(itemEntity);
        return itemEntity;
    }

    public void deleteById(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Item not found with id: " + id);
        } else {
            itemRepository.deleteById(id);
        }
    }

    public ItemEntity update(Long id, ItemEntity itemEntity) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Item not found with id: " + id);
        }
         return itemRepository.save(itemEntity);
    }
}
