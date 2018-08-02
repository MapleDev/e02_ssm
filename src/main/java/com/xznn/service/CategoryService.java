package com.xznn.service;

import com.xznn.pojo.Category;
import com.xznn.util.Page;

import java.util.List;

public interface CategoryService {
    List<Category> list();
    List<Category> list(Page page);
    int total();
}
