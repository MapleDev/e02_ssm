package com.xznn.mapper;

import com.xznn.pojo.Category;

import java.util.List;

public interface CategoryMapper {

    void add(Category category);

    int delete(int id);

    int update(Category category);

    Category get(int id);

    List<Category> list();

//    int count();

}
