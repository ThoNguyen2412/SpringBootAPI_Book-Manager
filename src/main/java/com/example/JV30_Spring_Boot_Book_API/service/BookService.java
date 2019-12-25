/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.JV30_Spring_Boot_Book_API.service;

import com.example.JV30_Spring_Boot_Book_API.entities.BookDetailEntity;
import com.example.JV30_Spring_Boot_Book_API.entities.BookEntity;
import com.example.JV30_Spring_Boot_Book_API.repository.BookDetailRepository;
import com.example.JV30_Spring_Boot_Book_API.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ThoNguyen
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDetailRepository bookDetailRepository;

    public List<BookEntity> getBooks() {
        return (List<BookEntity>) bookRepository.findAll();
    }

   
}
