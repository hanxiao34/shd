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
import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by DELL on 2019/1/22.
 */
@Component
public class WrjServie {
    private static final Logger LOG = LoggerFactory.getLogger(WrjServie.class);
    @Autowired
    WrjRepository wrjRepository;

    @Autowired
    WrjMatchRepository wrjMatchRepository;
   private static ScheduledExecutorService executors = Executors.newScheduledThreadPool(4);

    @PostConstruct
    public  void startFetch(){
        LOG.info("======startFetch");
        executors.schedule(r,10, TimeUnit.SECONDS);


    }

    private static Runnable r;

    {
        r = () -> {
            long maxid = wrjMatchRepository.getMaxWbId();
            LOG.info("get status: maxid:{}",maxid);
            String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
            Timeline tm = new Timeline(access_token);
            try {
                Map<String, String> parm = new HashMap<>();
                parm.put("since_id", maxid+"");
                parm.put("count", "100");

                StatusWapper status = tm.getMentions(parm);
                List<Status> statuses = status.getStatuses();
                for (Status s:statuses) {
                    LOG.info("id:{},status:{}",s.getId(), s);
                    Wrj wrj =new Wrj(s);
                    wrjRepository.save(wrj);
                }
                if (statuses==null||statuses.size()==0){
                    LOG.info("======no need statuses");
                }
            } catch (Exception e) {
                 LOG.error("get status error",e);
            } finally {
                executors.schedule(r, 10, TimeUnit.SECONDS);
            }
        };
    }


}
