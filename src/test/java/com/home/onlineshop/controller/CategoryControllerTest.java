package com.home.onlineshop.controller;

import com.home.Application;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = Application.class)
@TestPropertySource("classpath:application-test.yml")
public class CategoryControllerTest {

    @Autowired
    private CategoryController categoryController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void initializeRestAssuredMockMvc(){
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void getAll() throws Exception {
//        given().
//                when().g
//                .when()
//                .then()
//                .assert()
    }

    @Test
    public void createCategory() {
    }

    @Test
    public void deleteCategory() {
    }
}