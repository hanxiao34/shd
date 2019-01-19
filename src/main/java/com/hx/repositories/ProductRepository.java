/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hx.repositories;

import com.hx.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *
 * @author didin
 */
public interface ProductRepository extends CrudRepository<Product, String> {

    @Override
    Optional<Product> findById(String id);
    
    @Override
    void delete(Product deleted);
}