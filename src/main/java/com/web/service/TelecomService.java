package com.web.service;

import java.util.*;

import com.web.Dao.AppDao;
import com.web.bean.AppBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class TelecomService {

    @Autowired
    private AppDao appDao;

    public AppBean getUser(String username){
        return  appDao.getUser(username);
    }

    public void register(AppBean AppBean){
        appDao.register(AppBean);
    }

    public List<Map<String, Object>> getPart31() {
        List<Map<String, Object>> lists = new ArrayList<>();

        Jedis jedis = new Jedis("hdp");
        Set<String> hkeys = jedis.hkeys("business::order::total");
        for (String hkey : hkeys) {
            Map<String, Object> hashMap = new HashMap<>();
            String value = jedis.hget("business::order::total", hkey);
            System.out.println(hkey + "," + value);

            //写出
            hashMap.put("name",hkey);
            hashMap.put("value",value);
            lists.add(hashMap);
        }

        return lists;
    }




}
