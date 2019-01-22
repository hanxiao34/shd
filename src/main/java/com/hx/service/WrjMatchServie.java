package com.hx.service;

import com.hx.controller.JpRestController;
import com.hx.models.Wrj;
import com.hx.repositories.WrjMatchRepository;
import com.hx.repositories.WrjRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import weibo4j.Timeline;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by DELL on 2019/1/22.
 */
@Component
public class WrjMatchServie {
    private static final Logger LOG = LoggerFactory.getLogger(WrjMatchServie.class);
    @Autowired
    WrjRepository wrjRepository;

    @Autowired
    WrjMatchRepository wrjMatchRepository;
   private static ScheduledExecutorService executors = Executors.newScheduledThreadPool(4);

    @PostConstruct
    public  void startMatch(){
        LOG.info("======startMatch");
        executors.schedule(r,10, TimeUnit.SECONDS);


    }

    private static Runnable r;

    {
        r = () -> {
            try{
                 Wrj oneForMatch = wrjMatchRepository.findOneForMatch();
                if (oneForMatch!=null){
                    Wrj wrj = wrjMatchRepository.finDMatchFriden(oneForMatch.getHave(), oneForMatch.getWant());
                    oneForMatch.setResp(wrj.getResp()+"@"+oneForMatch.getUsername()+" @"+wrj.getUsername());
                    wrj.setResp(wrj.getResp()+"@"+oneForMatch.getUsername()+" @"+wrj.getUsername());
                    wrj.setStatus("3");
                    oneForMatch.setStatus("3");
                    wrjRepository.save(wrj);
                    wrjRepository.save(oneForMatch);
                }else{
                    LOG.info("match servie : no need to match");
                }
            } catch (Exception e) {
                 LOG.error("get status error",e);
            } finally {
                executors.schedule(r, 10, TimeUnit.SECONDS);
            }
        };
    }


}
