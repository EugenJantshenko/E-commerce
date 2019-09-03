package com.home.onlineshop.service.ware.impl;

import com.home.Application;
import com.home.onlineshop.entity.Ware;
import com.home.onlineshop.entity.WareCategory;
import com.home.onlineshop.entity.WareType;
import com.home.onlineshop.repository.WareRepository;
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

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.yml")
@Sql(value = {"/insert-wares.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = {"/drop-tables.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class WareServiceImplTest {

    @Autowired
    private WareRepository wareRepository;


    @Test
    public void test() {
        assertThat(wareRepository).isNotNull();
    }

    @Test
    @Transactional
    public void create() {
        Ware ware = new Ware();
        ware.setWareName("TestWare");
        ware.setSold(false);
        ware.setManufacturer("testManufacturer");
        ware.setPrice(123d);
        WareType type = new WareType();
        WareCategory cat = new WareCategory();
        cat.setCategoryName("TestCategory");
        type.setTypeName("TestType");
        type.setWareCategory(cat);
        ware.setWareType(type);
        Ware created = wareRepository.save(ware);
        assertThat(created.getWareName()).isSameAs("TestWare");
        assertThat(created.getWareType().getTypeName()).isSameAs("TestType");
        assertThat(created.getSold()).isFalse();
        assertThat(created.getWareType().getWareCategory().getCategoryName()).isSameAs("TestCategory");
    }

    @Test
    @Transactional
    public void update() {
        Optional<Ware> ware = wareRepository.findById(3L);
        ware.get().setManufacturer("new Manufacturer");
        assertThat(wareRepository.findById(3L).get().getManufacturer()).isSameAs("new Manufacturer");
    }

    @Test
    public void getAll() {
        Iterable<Ware> collection = wareRepository.findAll();
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(16);
    }

    @Test
    public void getAllByManufacturer() {
        Iterable<Ware> collection = wareRepository.findAllByManufacturer("Manufacturer 1");
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(10);
    }

    @Test
    public void getAllByWareName() {
        Iterable<Ware> collection = wareRepository.findAllByWareName("Ware 1");
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(3);
    }

    @Test
    public void delete() {
        wareRepository.deleteById(1L);
        Iterable<Ware> collection = wareRepository.findAll();
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(15);
    }
}