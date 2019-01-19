/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hx.controller;

import com.hx.models.Jp;
import com.hx.models.Product;
import com.hx.repositories.JpMatchRepository;
import com.hx.repositories.JpRepository;
import com.hx.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 *
 * @author didin
 */
@Controller
public class JpController {
    private static final Logger LOG = LoggerFactory.getLogger(JpController.class);
    @Autowired
    JpRepository productRepository;

    @Autowired
    JpMatchRepository jpMatchRepository;

    @RequestMapping("/jp")
    public String product(Model model) {
        model.addAttribute("str","ALL");
        model.addAttribute("count",productRepository.count());
        model.addAttribute("jps", jpMatchRepository.findall());
        return "product";
    }

    @RequestMapping("/jp/create")
    public String create(Model model) {
        return "create";
    }

    @RequestMapping("/jp/save")
    public String save(Model model,@RequestParam String havefrom, @RequestParam String haveto, @RequestParam String wantfrom, @RequestParam String wantto, @RequestParam String ltb, @RequestParam String date) {
       if (StringUtils.isEmpty(havefrom)){
           model.addAttribute("msg","出发地不能为空");
           return "create";
       }if (StringUtils.isEmpty(haveto)){
            model.addAttribute("msg","到达地不能为空");
            return "create";
        }
        if (StringUtils.isEmpty(date)){
            model.addAttribute("msg","机票日期不能为空");
            return "create";
        }
        if (StringUtils.isEmpty(ltb)){
            model.addAttribute("msg","聊天宝账号不能为空");
            return "create";
        }
        List<Jp> jps = jpMatchRepository.matchLtb(ltb);
        if (jps!=null&&jps.size()>=3){
            return "toomany";
        }

        Jp product = new Jp();
        product.setHavefrom(havefrom);
        product.setHaveto(haveto);
        product.setWantfrom(wantfrom);
        product.setWantto(wantto);
        product.setLtb(ltb);
        product.setDate(date);
        productRepository.save(product);

        return "redirect:/jp";
    }
    @RequestMapping("/jp/my")
    public String my(Model model,@CookieValue String ltb) {
        LOG.info("my:{}",ltb);
        List<Jp> jps;
        if (StringUtils.isEmpty(ltb)){
            jps=jpMatchRepository.findall();
        }else {
            jps=jpMatchRepository.matchLtb(ltb);
        }
        model.addAttribute("count",productRepository.count());
        model.addAttribute("jps",jps);
        model.addAttribute("str","我的机票");
        return "product";
    }
    @RequestMapping("/jp/show/{id}")
    public String show(@PathVariable String id, Model model) {

        model.addAttribute("jp", productRepository.findById(id).get());
        return "jp/show";
    }
    @RequestMapping("/jp/matchs")
    public String match(Model model,@RequestParam String havefrom, @RequestParam String haveto, @RequestParam String wantfrom, @RequestParam String wantto) {
        model.addAttribute("str","我有:"+havefrom+"->"+haveto+",想要"+wantfrom+"->"+(wantto==null?"anywhere":wantto));
        model.addAttribute("jps", jpMatchRepository.match(havefrom,haveto,wantfrom,wantto));
        model.addAttribute("count",productRepository.count());
        return "product";
    }
    @RequestMapping("/jp/match")
    public String match() {

        return "match";
    }
    @RequestMapping("/jp/delete")
    public String delete(@RequestParam String id) {
        Jp product = productRepository.findById(id).get();
        productRepository.delete(product);

        return "redirect:/jp";
    }
    
    @RequestMapping("/jp/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("product", productRepository.findById(id).get());
        return "edit";
    }
    
    @RequestMapping("/jp/update")
    public String update(@RequestParam String id, @RequestParam String prodName, @RequestParam String prodDesc, @RequestParam Double prodPrice, @RequestParam String prodImage) {
//        Jp product = productRepository.findById(id).get();
//        product.setProdName(prodName);
//        product.setProdDesc(prodDesc);
//        product.setProdPrice(prodPrice);
//        product.setProdImage(prodImage);
//        productRepository.save(product);

        return "redirect:/jp/show/" +1;
    }
}
