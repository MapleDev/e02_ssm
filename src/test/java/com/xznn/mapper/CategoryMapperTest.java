package com.xznn.mapper;

import com.xznn.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CategoryMapperTest {

    @Autowired
    CategoryService categoryService;

    @Test
    public void testAddTwoTestTrans() {
        categoryService.addTwoTestTrans();
    }
}