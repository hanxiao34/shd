package com.hx.service;

import com.hx.controller.JpRestController;
import com.hx.models.Wrj;
import com.hx.repositories.WrjMatchRepository;
import com.hx.repositories.WrjRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import weibo4j.Comments;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Comment;
import weibo4j.model.WeiboException;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by DELL on 2019/1/22.
 */
@Component
public class WrjNotifyServie {
    private static final Logger LOG = LoggerFactory.getLogger(WrjNotifyServie.class);
    @Autowired
    WrjRepository wrjRepository;

    @Autowired
    WrjMatchRepository wrjMatchRepository;
   private static ScheduledExecutorService executors = Executors.newScheduledThreadPool(4);

    @PostConstruct
    public  void startNotify(){
        LOG.info("======startNotify");
        executors.schedule(r,10, TimeUnit.SECONDS);


    }

    private static Runnable r;

    {
        r = () -> {
            try{
                 List<Wrj> forNotify = wrjMatchRepository.findForNotify();
                if (forNotify!=null){
                    for (Wrj w:forNotify) {
                        String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
                        String comments = w.getResp();
                        Comments cm = new Comments(access_token);
                        try {
                            Comment comment = cm.createComment(comments, w.getMid());
                            w.setStatus("2");
                            LOG.info("comment:{}",comment);
                            wrjRepository.save(w);
                        } catch (WeiboException e) {
                        }
                    }
                }else{
//                    LOG.info("match servie : no need to match");
                }
            } catch (Exception e) {
                 LOG.error("get forNotify error",e);
            } finally {
                executors.schedule(r, 10, TimeUnit.SECONDS);
            }
        };
    }


}
