package com.home.onlineshop.service.ware.impl;

import com.home.Application;
import com.home.onlineshop.entity.WareCategory;
import com.home.onlineshop.repository.WareCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.yml")
@Sql(value = {"/insert-wares.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class WareCategoryServiceImplTest {

    @Autowired
    private WareCategoryRepository wareCategoryRepository;

    @Test
    public void test() {
        assertThat(wareCategoryRepository).isNotNull();
    }

    @Test
    public void create() {
        WareCategory cat = new WareCategory();
        cat.setCategoryName("TestCategory");
        WareCategory created = wareCategoryRepository.save(cat);
        assertThat(created.getCategoryName()).isSameAs("TestCategory");
    }

    @Test
    public void getAll() {
        Iterable<WareCategory> collection = wareCategoryRepository.findAll();
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(5);
    }

    @Test
    public void delete() {
        wareCategoryRepository.deleteById(1L);
        Iterable<WareCategory> collection = wareCategoryRepository.findAll();
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(4);
    }
}