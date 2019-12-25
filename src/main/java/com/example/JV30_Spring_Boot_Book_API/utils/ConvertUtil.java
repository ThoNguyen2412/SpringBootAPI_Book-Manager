/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.JV30_Spring_Boot_Book_API.utils;

import com.example.JV30_Spring_Boot_Book_API.entities.BookEntity;
import com.example.JV30_Spring_Boot_Book_API.model.Book;
import com.example.JV30_Spring_Boot_Book_API.model.BookDetail;
import com.example.JV30_Spring_Boot_Book_API.model.Category;
import java.text.SimpleDateFormat;

/**
 *
 * @author ThoNguyen
 */
public class ConvertUtil {

    public static SimpleDateFormat formatter
            = new SimpleDateFormat("yyyy-MM-dd");

    public static Book convertBookFromBookEntity(
            BookEntity bookEntity) {
        Category category = new Category(
                bookEntity.getCategory().getId(),
                bookEntity.getCategory().getName());

        String publishDate = "";
        if (bookEntity.getBookDetail().getPublishDate() != null) {
            publishDate = formatter.format(
                    bookEntity.getBookDetail().getPublishDate());
        }

        BookDetail bookDetail = new BookDetail(
                bookEntity.getBookDetail().getId(),
                bookEntity.getBookDetail().getIsbn(),
                bookEntity.getBookDetail().getNumberOfPage(),
                bookEntity.getBookDetail().getPrice(),
                publishDate,
                bookEntity.getBookDetail().getDescription());

        return new Book(bookEntity.getId(), bookEntity.getName(),
                bookEntity.getAuthor(), category, bookDetail);
    }
}
