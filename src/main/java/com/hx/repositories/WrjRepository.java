/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hx.repositories;

import com.hx.models.Jp;
import com.hx.models.Wrj;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *
 * @author didin
 */
public interface WrjRepository extends CrudRepository<Wrj, String> {

    @Override
    Optional<Wrj> findById(String id);
    
    @Override
    void delete(Wrj deleted);
}