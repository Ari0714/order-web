package com.web.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.web.Dao.AppDao;
import com.web.bean.AppBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Author Ari
 * Date 2026/1/21
 * Desc
 */
@Service
public class KafkaConsumer {

    @Autowired
    private AppDao appDao;

    @KafkaListener(topics = "test_t")
    public void listen(String message){
        System.out.println("receive message: "+ message);

        AppBean.AppBeanBuilder builder = AppBean.builder();

        AppBean build = null;
        try {
            JSONObject jsonObject = JSON.parseObject(message);
            String username = jsonObject.getString("username");
            String gender = jsonObject.getString("gender");
            String age = jsonObject.getString("age");
            String occupation = jsonObject.getString("occupation");
            String zipCode = jsonObject.getString("zip_code");

            builder.username(username);
            builder.username(gender);
            builder.username(age);
            builder.username(occupation);
            builder.username(zipCode);
            build = builder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        appDao.register(build);

    }

}
