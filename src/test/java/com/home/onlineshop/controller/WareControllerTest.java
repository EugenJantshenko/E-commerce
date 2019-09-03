package com.home.onlineshop.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application.yml")
@Sql(value = {"/create-tables.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/insert-wares.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class WareControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WareController wareController;


    @Test
    public void getAllWares() {
    }

    @Test
    public void getCount() {
    }

    @Test
    public void createWare() {
    }

    @Test
    public void updateWare() {
    }

    @Test
    public void deleteWare() {
    }
}