package com.xznn.mapper;

import com.xznn.pojo.Category;
import com.xznn.util.Page;

import java.util.List;

public interface CategoryMapper {

    int add(Category category);

    int delete(int id);

    int update(Category category);

    Category get(int id);

    List<Category> list();

    List<Category> list(Page page);

    int total();

}
