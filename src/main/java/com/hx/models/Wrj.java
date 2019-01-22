/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hx.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import weibo4j.model.Comment;
import weibo4j.model.Status;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author didin
 */
@Document(collection = "wrj")
public class Wrj {
    @Id
    String id;
    private long createdAt;                    //评论时间
    private String mid;						   //评论id
    private String idstr;					   //评论id
    private String text;                       //评论内容
    private String have="";
    private String want="";
    private String source;                     //内容来源
    private  String userid = null;                  //User对象
    private String username="";
    private String status = "0";              // 0 not   1  已匹配 2 待回复 3 已回复
    private String resp="";
    private boolean join=true;

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public boolean isJoin() {
        return join;
    }

    public void setJoin(boolean join) {
        this.join = join;
    }
    public Wrj(){}
    private static Pattern pattern = Pattern.compile("#(.{1,10})换(.{1,10})@");
    public Wrj(String id, long createdAt, String mid, String idstr, String text, String have, String want, String source, String userid, String username, String status) {
        this.id = id;
        this.createdAt = createdAt;
        this.mid = mid;
        this.idstr = idstr;
        this.text = text;
        this.have = have;
        this.want = want;
        this.source = source;
        this.userid = userid;
        this.username = username;
        this.status = status;
    }
    public Wrj(Comment c){
        this.id=c.getIdstr();
        this.createdAt=c.getCreatedAt().getTime();
        this.mid=c.getMid();
        this.idstr=c.getIdstr();
        this.text=c.getText();
        this.source=c.getSource();
        this.userid=c.getUser().getId();
        this.username=c.getUser().getName();
        this.status="0";

        processText(c.getText());
    }
    public Wrj(Status s){
        this.id=s.getId();
        this.status="0";
        this.username=s.getUser().getName();
        this.userid=s.getUser().getId();
        this.source=s.getSource().getName();
        this.text=s.getText();
        this.idstr=s.getIdstr()+"";
        this.mid=s.getMid();
        this.createdAt=s.getCreatedAt().getTime();
        processText(s.getText());
    }

    private void processText(String text) {
        if (text.contains("#宋焕铎大行动#")){
            if (text.contains("#tello无人机#")){
                Matcher matcher = pattern.matcher(text);
                if (matcher.find()){
                    this.have=(matcher.group(1).replaceAll("[^\\u4e00-\\u9fa5]",""));;
                    this.want=(matcher.group(2).replaceAll("[^\\u4e00-\\u9fa5]",""));;
                    this.status="0";

                }
            }else{
                this.resp="请问你要参加哪个活动？";
                this.status="3";
            }
        }else{
            //不是参加活动的
            this.join=false;
        }
        //
    }

    public Wrj(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHave() {
        return have;
    }

    public void setHave(String have) {
        this.have = have;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void main(String[] args) {
        String source="#宋焕铎大行动# #tello无人机#青海换四川@萌萌的罗宾叔";

        Matcher matcher = pattern.matcher(source);
            if (matcher.find()){
               System.out.println(matcher.group(1).replaceAll("[^\\u4e00-\\u9fa5]",""));;
               System.out.println(matcher.group(2).replaceAll("[^\\u4e00-\\u9fa5]",""));;
            }
    }
}
