/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.JV30_Spring_Boot_Book_API.repository;

import com.example.JV30_Spring_Boot_Book_API.entities.BookEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ThoNguyen
 */
@Repository
public interface BookRepository
        extends CrudRepository<BookEntity, Integer> {

    public List<BookEntity> findByNameLikeOrAuthor(String name,
            String author);

    public List<BookEntity>
            findByNameContainingOrAuthorContaining(String name, String author);

    @Query("Select b From BookEntity b "
            + "Where b.category.name Like ?1 "
            + "Order By b.bookDetail.price Asc")
    public List<BookEntity> findBookByCategory(String name);

    @Query(value = "Select * from book b "
            + "inner join category c on b.category_id = c.id "
            + "inner join book_detail bd on bd.id = b.book_detail_id "
            + "where c.name Like ?1 "
            + "Order By bd.price Asc", nativeQuery = true)
    public List<BookEntity> findBookByCategoryNative(String name);
}
