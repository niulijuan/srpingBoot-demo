package com.niulijuan.springbootdemo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * restful 风格demo
 * @author niulijuan
 * @date 2019-10-12 10:39
 */
@RestController
@RequestMapping("/restful")
@Slf4j
public class RestfulController {


    @GetMapping()
    public String get(String id){
        return id;
    }

    @PostMapping
    public String post(@RequestBody User user){
        log.info("{}",user);
        return "post success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        return "delete success";
    }
}
