package com.niulijuan.springbootdemo.demo.controller;

import com.niulijuan.springbootdemo.demo.DemoApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author niulijuan
 * @date 2019-10-12
 */
public class RestfulControllerTest extends DemoApplicationTests {


    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testGet() throws Exception{
        RequestBuilder request = get("/restful?id=123");
        mockMvc.perform(request)
                .andExpect(content().string("123"));
    }

    @Test
    public void testPost() throws Exception {
        RequestBuilder request = post("/restful")
                .content("{'id':1,'name':'nlj'}");
        mockMvc.perform(request)
                .andExpect(content().string("post success"));
    }

    @Test
    public void testDelete() throws Exception{
        RequestBuilder request = delete("/restful/111");
        mockMvc.perform(request)
                .andExpect(content().string("delete success"));
    }

}