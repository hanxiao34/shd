/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hx.repositories;

import com.hx.models.Jp;
import com.hx.models.Wrj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 *
 * @author hx
 */
@Repository
public class WrjMatchRepository {

    @Autowired
    private MongoOperations mongoOperations;


    public long getMaxWbId(){
        try {
            Query query = new Query().limit(1);
            List<Wrj> ids = mongoOperations.find(query.with(new Sort(Sort.Direction.DESC, "id")), Wrj.class);
            if (ids != null && ids.size() > 0) {
                return Long.parseLong(ids.get(0).getId());
            }
        }catch ( Exception e){

        }
        return 0l;
    }

}