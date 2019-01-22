/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hx.repositories;

import com.hx.models.Jp;
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
public class JpMatchRepository{

    @Autowired
    private MongoOperations mongoOperations;

    public List<Jp> match(String from, String to, String wantfrom , String wantto){
        Jp jp=new Jp();
        if (!StringUtils.isEmpty(wantfrom)) {
        jp.setHavefrom(wantfrom);
        }
        if (!StringUtils.isEmpty(wantto)) {
            jp.setHaveto(wantto);
        }
        if (!StringUtils.isEmpty(from)) {
            jp.setWantfrom(from);
        }
        if (!StringUtils.isEmpty(to)) {
            jp.setWantto(to);
        }

        Query query=new Query(Criteria.byExample(jp));

       return mongoOperations.find(query.with(new Sort(Sort.Direction.DESC,"id")),Jp.class);
    }
    public List<Jp> matchLtb(String ltb){
        Jp jp=new Jp();

        jp.setLtb(ltb);

        Query query=new Query(Criteria.byExample(jp)).limit(5);
        return mongoOperations.find(query.with(new Sort(Sort.Direction.DESC,"id")),Jp.class);
    }
    public List<Jp> findall(){

        Query query=new Query().limit(50);

        return mongoOperations.find(query.with(new Sort(Sort.Direction.DESC,"id")),Jp.class);
    }
}