package com.example.JPAbasedApp.service;

import com.example.JPAbasedApp.model.LibraryCard;
import com.example.JPAbasedApp.Repository.LibraryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    LibraryCardRepository libraryCardRepository;
    public String addCard(LibraryCard libraryCard) {
        libraryCardRepository.save(libraryCard);
        return "success!";
    }
}
