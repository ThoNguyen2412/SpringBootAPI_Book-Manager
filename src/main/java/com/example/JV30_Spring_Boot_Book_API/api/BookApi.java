/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.JV30_Spring_Boot_Book_API.api;


import com.example.JV30_Spring_Boot_Book_API.entities.BookEntity;
import com.example.JV30_Spring_Boot_Book_API.model.Book;
import com.example.JV30_Spring_Boot_Book_API.service.BookService;
import com.example.JV30_Spring_Boot_Book_API.utils.ConvertUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author ThoNguyen
 */
@RestController
@RequestMapping("/api")
public class BookApi {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books",
            method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks() {
        List<BookEntity> bookEntitys
                = bookService.getBooks();
        List<Book> books = new ArrayList<>();
        if (bookEntitys != null && bookEntitys.size() > 0) {
            for (BookEntity bookEntity : bookEntitys) {
                books.add(
                        ConvertUtil.convertBookFromBookEntity(bookEntity)
                );
            }
            return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

//    @RequestMapping(value = "/book/{bookId}",
//            method = RequestMethod.GET)
//    public ResponseEntity<Book> getBook(
//            @PathVariable("bookId") int bookId) {
//        BookEntity bookEntity = bookService.findBookById(bookId);
//        if (bookEntity.getId() > 0) {
//            return new ResponseEntity<Book>(
//                    ConvertUtil.convertBookFromBookEntity(bookEntity),
//                    HttpStatus.OK
//            );
//        } else {
//            return new ResponseEntity("Not found book "
//                    + "with id: " + bookId, HttpStatus.NOT_FOUND);
//        }
//    }

//    @RequestMapping(value = "/book", method = RequestMethod.POST)
//    public ResponseEntity<?> addBook(
//            @RequestBody BookEntity bookEntity,
//            UriComponentsBuilder builder) {
//        bookEntity = bookService.saveBook(bookEntity);
//        if (bookEntity.getId() > 0) {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setLocation(builder.path(
//                    "/api/book/{bookId}").buildAndExpand(
//                            bookEntity.getId()
//                    ).toUri());
//            return new ResponseEntity(headers, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity("Add book is fail.",
//                    HttpStatus.NOT_ACCEPTABLE);
//        }
//    }
//
//    @RequestMapping(value = "/book",
//            method = RequestMethod.PUT)
//    public ResponseEntity<?> updateBook(
//            @RequestBody BookEntity bookEntity,
//            UriComponentsBuilder builder) {
//        BookEntity bookSaved = bookService.saveBook(bookEntity);
//        if (bookSaved != null && bookSaved.getId() > 0) {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setLocation(builder.path(
//                    "/api/book/{bookId}").buildAndExpand(
//                            bookEntity.getId()
//                    ).toUri());
//            return new ResponseEntity(headers, HttpStatus.OK);
//        } else {
//            return new ResponseEntity("update book is fail.",
//                    HttpStatus.NOT_ACCEPTABLE);
//        }
//    }
//
//    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.DELETE)
//    public ResponseEntity<Book> deleteBook(
//            @PathVariable("bookId") int bookId) {
//        if (!bookService.deleteBook(bookId)) {
//            return new ResponseEntity(HttpStatus.OK);
//        } else {
//            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//        }
//    }
//
//    @RequestMapping(value = "/search-book", method = RequestMethod.POST)
//    public ResponseEntity<List<Book>> searchBook(
//            @ModelAttribute("searchTxt") String searchTxt) {
//        List<BookEntity> bookEntitys
//                = bookService.searchBook(searchTxt);
//        List<Book> books = new ArrayList<>();
//        if (bookEntitys != null && bookEntitys.size() > 0) {
//            for (BookEntity bookEntity : bookEntitys) {
//                books.add(
//                        ConvertUtil.convertBookFromBookEntity(bookEntity)
//                );
//            }
//            return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
//        } else {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//    }
}
