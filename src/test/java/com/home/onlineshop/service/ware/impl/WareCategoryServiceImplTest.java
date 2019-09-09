package com.home.onlineshop.service.ware.impl;

import com.home.onlineshop.entity.WareCategory;
import com.home.onlineshop.repository.WareCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@TestPropertySource("classpath:application-test.yml")
@Transactional(readOnly = true)
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,scripts = {"classpath:drop-tables.sql","classpath:create-tables.sql","classpath:insert-wares.sql"})
public class WareCategoryServiceImplTest {

    @Autowired
    private WareCategoryRepository wareCategoryRepository;

    @Test
    public void shouldFailWhenWareCategoryRepositoryIsNull() {
        assertThat(wareCategoryRepository).isNotNull();
    }

    @Test
    public void shouldCreateNewWareCategory() {
        WareCategory cat = new WareCategory();
        cat.setCategoryName("TestCategory");
        WareCategory created = wareCategoryRepository.save(cat);
        assertThat(created.getCategoryName()).isSameAs("TestCategory");
    }

    @Test
    public void shouldCheckCountOfWareCategory() {
        Iterable<WareCategory> collection = wareCategoryRepository.findAll();
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(5);
    }

    @Test
    public void shouldDeleteWareCategoryById() {
        wareCategoryRepository.deleteById(1L);
        Iterable<WareCategory> collection = wareCategoryRepository.findAll();
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(4);
    }
}