package com.home.onlineshop;


import com.home.onlineshop.controller.WareController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private WareController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void contextLoad() throws Exception {
        this.mockMvc.perform(get("/wares/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }

}
