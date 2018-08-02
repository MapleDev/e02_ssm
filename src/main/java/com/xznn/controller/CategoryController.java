package com.xznn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xznn.pojo.Category;
import com.xznn.service.CategoryService;
import com.xznn.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/listCategory")
    public ModelAndView listCategory() {
        return new ModelAndView("listCategory", "cs", categoryService.list());
    }

    @RequestMapping("/listCategoryByPage")
    public ModelAndView listCategoryByPage(Page page) {
        ModelAndView modelAndView = new ModelAndView("listCategory");
        page.calculateLast(categoryService.total());
        modelAndView.addObject("cs", categoryService.list(page));

        return modelAndView;
    }

    @RequestMapping("/listCategoryByPageHelper")
    public ModelAndView listCategoryByPageHelper(Page page) {
        PageHelper.offsetPage(page.getStart(), 5);

        ModelAndView modelAndView = new ModelAndView("listCategory");
        List<Category> cs = categoryService.list();
        page.calculateLast((int) new PageInfo<>(cs).getTotal());
        modelAndView.addObject("cs", cs);

        return modelAndView;
    }

}
