/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.JV30_Spring_Boot_Book_API.repository;

import com.example.JV30_Spring_Boot_Book_API.entities.CategoryEntity;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ThoNguyen
 */
@Repository
public interface CategoryRepository
        extends CrudRepository<CategoryEntity, Integer> {

}
