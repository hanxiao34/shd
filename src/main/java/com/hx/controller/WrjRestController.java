/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hx.controller;

import com.hx.dataobject.Result;
import com.hx.models.Jp;
import com.hx.repositories.JpMatchRepository;
import com.hx.repositories.JpRepository;
import com.hx.repositories.WrjMatchRepository;
import com.hx.repositories.WrjRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author didin
 */
@RestController
public class WrjRestController {
    private static final Logger LOG = LoggerFactory.getLogger(WrjRestController.class);
    @Autowired
    WrjRepository wrjRepository;

    @Autowired
    WrjMatchRepository wrjMatchRepository;

    @RequestMapping("/d/wrj/all")
    public Result alljp() {
        Result r =new Result();
        Map m =new HashMap();
        m.put("count",wrjRepository.count());
        m.put("datas", wrjMatchRepository.findall());
        r.setData(m);
        return r;
    }

}
