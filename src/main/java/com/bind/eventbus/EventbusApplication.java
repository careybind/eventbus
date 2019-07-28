package com.bind.eventbus;

import com.bind.eventbus.event.CustomerEvent;
import com.bind.eventbus.logic.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

@Controller
@SpringBootApplication
@RequestMapping("/test")
public class EventbusApplication {
    @Autowired
    private Publisher publisher;
    public static void main(String[] args) {
        SpringApplication.run(EventbusApplication.class, args);
    }
    @RequestMapping("/zlevent")
    @ResponseBody
    public String test(){
       publisher.publishCustomer("a","b","ca",1);
        System.out.println(Thread.currentThread().getName()+"完成");
        return "success!";
    }
}
