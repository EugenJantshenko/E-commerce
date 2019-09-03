package com.home.onlineshop.service.ware.impl;

import com.home.Application;
import com.home.onlineshop.entity.WareCategory;
import com.home.onlineshop.entity.WareType;
import com.home.onlineshop.repository.WareTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.yml")
@Sql(value = {"/insert-wares.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = {"/drop-tables.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class WareTypeServiceImplTest {

    @Autowired
    private WareTypeRepository wareTypeRepository;

    @Test
    public void test() {
        assertThat(wareTypeRepository).isNotNull();
    }

    @Test
    @Transactional
    public void create() {
        WareType type = new WareType();
        type.setBlocked(true);
        type.setTypeName("TestName");
        WareCategory cat = new WareCategory();
        cat.setCategoryName("TestCategory");
        type.setWareCategory(cat);
        WareType created = wareTypeRepository.save(type);
        assertThat(created.getTypeName()).isSameAs("TestName");
        assertThat(created.isBlocked()).isTrue();
        assertThat(created.getWareCategory().getCategoryName()).isSameAs("TestCategory");
    }

    @Test
    public void getAll() {
        Iterable<WareType> collection = wareTypeRepository.findAll();
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(9);
    }

    @Test
    public void lock() {
        WareType type = new WareType();
        type.setBlocked(true);
        type.setTypeName("lockTest");
        WareType created = wareTypeRepository.save(type);
        assertThat(created.isBlocked()).isTrue();
    }

    @Test
    public void unlock() {
        WareType type = new WareType();
        type.setBlocked(false);
        type.setTypeName("lockTest");
        WareType created = wareTypeRepository.save(type);
        assertThat(created.isBlocked()).isFalse();
    }

    @Test
    public void delete() {
        wareTypeRepository.deleteById(1L);
        Iterable<WareType> collection = wareTypeRepository.findAll();
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(8);
    }
}