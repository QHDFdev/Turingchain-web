package com.tulingchain.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tulingchain.model.Developer;
import com.tulingchain.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeveloperController {
    @Autowired
    DeveloperService developerService;

    @RequestMapping(value ="/dev/registe",method = RequestMethod.POST)
    public @ResponseBody String register(@RequestBody Developer developer){
        System.out.println(developer);
        int re=developerService.save(developer);
        return String.valueOf(re);
    }

    @RequestMapping(value ="/dev/login",method = RequestMethod.POST)
    public @ResponseBody String login(@RequestBody Developer developer){
        JSONObject obj= (JSONObject) JSON.toJSON(developerService.queryLogin(developer));
        return obj.toJSONString();
    }

    @RequestMapping(value = "/dev/listAllDevelopers",method = RequestMethod.GET)
    public @ResponseBody String listAll(){
        List<Developer> list=developerService.listAllDeveloper();

        return JSON.toJSONString(list);
    }
}
