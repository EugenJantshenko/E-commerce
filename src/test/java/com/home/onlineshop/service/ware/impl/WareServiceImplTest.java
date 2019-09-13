package com.home.onlineshop.service.ware.impl;

import com.home.onlineshop.entity.*;
import com.home.onlineshop.repository.WareRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@SpringBootTest
@TestPropertySource("classpath:application-test.yml")
@Transactional(readOnly = true)
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,scripts = {"classpath:drop-tables.sql","classpath:create-tables.sql","classpath:insert-wares.sql"})
public class WareServiceImplTest {

    @Autowired
    private WareRepository wareRepository;


    @Test
    public void shouldFailWhenWareRepositoryIsNull() {
        assertThat(wareRepository).isNotNull();
    }

    @Test
    @Transactional
    public void shouldCreateNewWare() {
        Ware ware = new Ware();
        ware.setWareName(new WareName());
        ware.setSold(false);
        ware.setManufacturerId(new Manufacturer());
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
    public void shouldUpdateWareById() {
        Optional<Ware> ware = wareRepository.findById(3L);
        ware.get().setManufacturerId(new Manufacturer());
        assertThat(wareRepository.findById(3L).get().getManufacturerId().getId()).isSameAs(3L);
    }

    @Test
    public void shouldCheckCountOfWare() {
        Iterable<Ware> collection = wareRepository.findAll();
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(16);
    }

    @Test
    public void shouldCheckCountOfWareByManufacturer() {
        Iterable<Ware> collection = wareRepository.findAllByManufacturerId(1L);
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(10);
    }

    @Test
    public void shouldCheckCountOfWareByWareName() {
        Iterable<Ware> collection = wareRepository.findAllByWareNameId(1L);
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(3);
    }

    @Test
    @Transactional
    public void shouldDeleteWareById() {
        wareRepository.deleteById(1L);
        Iterable<Ware> collection = wareRepository.findAll();
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(15);
    }
}