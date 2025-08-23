package com.backend.backend.controllers;

import com.backend.backend.config.RabbitMQConfig;
import com.backend.backend.entities.ItemEntity;
import com.backend.backend.services.ItemService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

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
        ResponseEntity<?> response =  ResponseEntity.ok(itemService.save(itemEntity));
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                "New item created: " + itemEntity.toString());
        return response;
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
