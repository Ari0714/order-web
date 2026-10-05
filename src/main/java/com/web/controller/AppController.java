package com.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.web.service.TelecomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
		
	@Autowired
	private TelecomService moveService;

	@RequestMapping(value = "getUser")
    public String getUser(@RequestParam("username") String username){
	    return moveService.getUser(username).toString();
    }

//    @PostMapping(value = "register")
//    public void register(AppBean appBean){
//	    moveService.register(appBean);
//    }


    @RequestMapping(value = "/getPart31")
    public Map getPart31(){

        List<Map<String,Object>> list = moveService.getPart31();
        List key = new ArrayList();
        List val = new ArrayList();
        Map returnMap = new HashMap<String, List>();
        for(Map<String,Object> m:list) {
            key.add(m.get("name"));
            val.add(m.get("value"));
        }

        returnMap.put("key", key);
        returnMap.put("val", val);

        return returnMap;
    }



}
