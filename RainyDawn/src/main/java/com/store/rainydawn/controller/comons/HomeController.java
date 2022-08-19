package com.store.rainydawn.controller.comons;

import com.store.rainydawn.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private AccountDAO acc;

    @RequestMapping("index")
    public String index(){
        System.out.println(acc.findAll());
        return "home/index";
    }
}
