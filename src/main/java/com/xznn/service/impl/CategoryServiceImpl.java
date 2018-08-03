package com.xznn.service.impl;

import com.github.pagehelper.PageInfo;
import com.xznn.mapper.CategoryMapper;
import com.xznn.pojo.Category;
import com.xznn.service.CategoryService;
import com.xznn.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }

    @Override
    public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }

    @Override
    public int total() {
        return categoryMapper.total();
    }

    @Override
    public int delete(int id) {
        return categoryMapper.delete(id);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.update(category);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }

    @Override
    public int add(Category category) {
        return categoryMapper.add(category);
    }

    @Override
//    @Transactional(propagation=Propagation.REQUIRED, rollbackForClassName="Exception")
    public void addTwoTestTrans() {
        Category c1 = new Category();
        c1.setName("短的名字");
        add(c1);

        Category c2 = new Category();
        c2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
        add(c2);
    }
}
