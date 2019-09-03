package com.home.onlineshop.repository;

import com.home.Application;
import com.home.onlineshop.entity.WareCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.yml")
@Sql(value = {"/insert-wares.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class WareCategoryRepositoryTest {

    @Autowired
    private WareCategoryRepository wareCategoryRepository;

    @Test
    public void test() {
        assertThat(wareCategoryRepository).isNotNull();
    }

    @Test
    public void findById() {
        Optional<WareCategory> category = wareCategoryRepository.findById(2L);
        System.out.println(category.toString());
        assertThat(category.get().getCategoryName()).isEqualTo("Category 2");
    }

    @Test
    public void existsByCategoryName() {
        assertThat(wareCategoryRepository.existsByCategoryName("Category 3")).isTrue();
    }
}