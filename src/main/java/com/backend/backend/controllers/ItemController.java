package com.backend.backend.controllers;

import com.backend.backend.entities.ItemEntity;
import com.backend.backend.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<?> getAllItems() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(Long id) {
        return ResponseEntity.ok(itemService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createItem(ItemEntity itemEntity) {
        return ResponseEntity.ok(itemService.save(itemEntity));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItemById(@PathVariable Long id) {
        itemService.deleteById(id);
        return ResponseEntity.ok("Item deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateItem(@PathVariable Long id, @RequestBody ItemEntity itemEntity) {
        return ResponseEntity.ok(itemService.update(id, itemEntity));
    }
}
