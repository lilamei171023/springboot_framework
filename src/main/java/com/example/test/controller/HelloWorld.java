package com.example.test.controller;

import com.example.test.service.IRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
@EnableAutoConfiguration
public class HelloWorld {
    @Autowired
    private IRegService regService;
    @RequestMapping("/")
    String home() {
        return "index";
    }
    @GetMapping("/reg")
    @ResponseBody
    Boolean reg(@RequestParam("userName") String userName, @RequestParam("userAge") String userAge ){
//        String userName = creatMD5(loginNum);
        System.out.println(userAge+":"+userName);
//        regService.regUser(userId,userName);
        return  regService.regUser(userAge,userName);
    }
    private String creatMD5(String loginNum){
        // 生成一个MD5加密计算摘要
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(loginNum.getBytes());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new BigInteger(1, md.digest()).toString(16);
    }
}