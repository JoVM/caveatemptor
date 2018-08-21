package com.amudhan.caveatemptor.controller;

import com.amudhan.caveatemptor.entity.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    Logger logger = LoggerFactory.getLogger(ItemController.class);

    @GetMapping(path = "/api/items")
    public ResponseEntity<Item> getItem() {
        return null;
    }

}
