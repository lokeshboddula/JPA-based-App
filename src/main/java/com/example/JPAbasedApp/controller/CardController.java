package com.example.JPAbasedApp.controller;

import com.example.JPAbasedApp.service.CardService;
import com.example.JPAbasedApp.model.LibraryCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;
    @PostMapping("/add")
    public String addCard(@RequestBody LibraryCard libraryCard){
        return cardService.addCard(libraryCard);
    }
}
