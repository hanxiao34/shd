/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hx.repositories;

import com.hx.models.Jp;
import com.hx.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *
 * @author didin
 */
public interface JpRepository extends CrudRepository<Jp, String> {

    @Override
    Optional<Jp> findById(String id);
    
    @Override
    void delete(Jp deleted);
}