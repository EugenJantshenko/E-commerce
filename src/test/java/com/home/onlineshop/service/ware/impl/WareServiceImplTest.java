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

import java.util.List;
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
        WareName name =new WareName();
        name.setNameId("TestName");
        ware.setName(name);
        ware.setSold(false);
        ware.setManufacturer(new Manufacturer());
        ware.setPrice(123d);
        WareType type = new WareType();
        WareCategory cat = new WareCategory();
        cat.setCategoryName("TestCategory");
        type.setTypeName("TestType");
        type.setWareCategory(cat);
        ware.setType(type);
        Ware created = wareRepository.save(ware);
        assertThat(created.getName().getNameId()).isSameAs("TestName");
        assertThat(created.getType().getTypeName()).isSameAs("TestType");
        assertThat(created.isSold()).isFalse();
        assertThat(created.getType().getWareCategory().getCategoryName()).isSameAs("TestCategory");
    }

    @Test
    @Transactional
    public void shouldUpdateWareById() {
        Optional<Ware> ware = wareRepository.findById(3L);
        Manufacturer manufacturer =new Manufacturer();
        manufacturer.setManufacturerName("TestManufacturer");
        ware.get().setManufacturer(manufacturer);
        assertThat(wareRepository.findById(3L).get().getManufacturer().getManufacturerName()).isSameAs("TestManufacturer");
    }

    @Test
    public void shouldCheckCountOfWare() {
        Iterable<Ware> collection = wareRepository.findAll();
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(16);
    }

    @Test
    public void shouldCheckCountOfWareByManufacturer() {
        List<Ware> collection = wareRepository.findAllByManufacturerId(1L);
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(3);
    }

    @Test
    public void shouldCheckCountOfWareByWareName() {
        List<Ware> collection = wareRepository.findAllByNameId(1L);
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(5);
    }

    @Test
    @Transactional
    public void shouldDeleteWareById() {
        wareRepository.deleteById(1L);
        Iterable<Ware> collection = wareRepository.findAll();
        assertThat(collection.spliterator().getExactSizeIfKnown()).isEqualTo(15);
    }
}