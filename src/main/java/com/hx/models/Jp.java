/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hx.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author didin
 */
@Document(collection = "jp")
public class Jp {
    @Id
    String id;
    String havefrom;
    String haveto;
    String wantfrom;
    String wantto;
    String ltb;
    String date;

    public Jp() {
    }

    public Jp(String havefrom, String haveto, String wantfrom, String wantto,String ltb,String date) {

        this.havefrom = havefrom;
        this.haveto = haveto;
        this.wantfrom = wantfrom;
        this.wantto = wantto;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHavefrom() {
        return havefrom;
    }

    public void setHavefrom(String havefrom) {
        this.havefrom = havefrom;
    }

    public String getHaveto() {
        return haveto;
    }

    public void setHaveto(String haveto) {
        this.haveto = haveto;
    }

    public String getWantfrom() {
        return wantfrom;
    }

    public void setWantfrom(String wantfrom) {
        this.wantfrom = wantfrom;
    }

    public String getWantto() {
        return wantto;
    }

    public void setWantto(String wantto) {
        this.wantto = wantto;
    }

    public String getLtb() {
        return ltb;
    }

    public void setLtb(String ltb) {
        this.ltb = ltb;
    }
}
