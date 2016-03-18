package com.ewangz.javaarchitecture.service;


import com.ewangz.javaarchitecture.AbstractTests;
import com.ewangz.javaarchitecture.IntegrationTestUtil;
import com.ewangz.javaarchitecture.model.Item;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by aaronqin on 16/3/18.
 */
public class ItemServiceTests extends AbstractTests {

    @Test
    public void testArticles() throws Exception {
        //没有设置任何参数
        //mockMvc.perform(post("/items")).andExpect(status().is4xxClientError());

        Item item = new Item();
        item.setDescription("test3");
        //Integer id = 2;

        //成功创建
        mockMvc.perform(post("/items")
                .content(IntegrationTestUtil.convertObjectToJsonBytes(item))
                .contentType(IntegrationTestUtil.APPLICATION_JSON_UTF8)).andExpect(status().isOk());

        /*mockMvc.perform(delete("/items/{id}", id)
                .contentType(IntegrationTestUtil.APPLICATION_JSON_UTF8)).andExpect(status().isOk());*/

        /*mockMvc.perform(get("/items")
                .contentType(IntegrationTestUtil.APPLICATION_JSON_UTF8)).andExpect(status().isOk());*/
    }

    @Test
    public void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

}
