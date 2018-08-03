package com.xznn.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xznn.pojo.Category;
import com.xznn.service.CategoryService;
import com.xznn.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
        PageHelper.offsetPage(page.getStart(), page.getCount());

        ModelAndView modelAndView = new ModelAndView("listCategory");
        List<Category> cs = categoryService.list();
        page.calculateLast((int) new PageInfo<>(cs).getTotal());
        modelAndView.addObject("cs", cs);

        return modelAndView;
    }

    @RequestMapping("/deleteCategory")
    public ModelAndView deleteCategory(int id) {
        int delete = categoryService.delete(id);
        System.out.println("delete = [" + delete + "]");

        return new ModelAndView("redirect:/listCategoryByPageHelper?start=" + new PageInfo<>(categoryService.list()).getPages());
    }


//    @RequestMapping(value="/deleteCategory")
//    public ModelAndView deleteCategory(Category category){
//        int delete = categoryService.delete(category.getId());
//        System.out.println("delete = [" + delete + "]");
//
//        return new ModelAndView("redirect:/listCategoryByPageHelper?start=" + new PageInfo<>(categoryService.list()).getPages());
//    }


    @RequestMapping("/editCategory")
    public ModelAndView editCategory(int id) {
        return new ModelAndView("editCategory", "category", categoryService.get(id));
    }

    @RequestMapping("/updateCategory")
    public ModelAndView updateCategory(Category category) {
        int update = categoryService.update(category);
        System.out.println("update = [" + update + "]");

        return new ModelAndView("redirect:/listCategoryByPageHelper");
    }

    @RequestMapping("/addCategory")
    public ModelAndView addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryService.add(category);

        List<Category> cs = categoryService.list();
        return new ModelAndView("redirect:/listCategoryByPageHelper?start=" + (int) new PageInfo<>(cs).getTotal());
    }


//    @ResponseBody
//    @RequestMapping("/submitCategory")
//    public String submitCategory(@RequestBody Category category) {
//        return categoryService.add(category) + "";
//    }

    @ResponseBody
    @RequestMapping("/submitCategory")
    public String submitCategory(@RequestBody Category category) {
        System.out.println("SSM接受到浏览器提交的json，并转换为Category对象:"+category);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOneCategory(int id) {
        Category category = categoryService.get(id);
        JSONObject json= new JSONObject();
        json.put("category", JSONObject.toJSON(category));
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/getManyCategory")
    public String getManyCategory(int start, int count) {
        PageHelper.offsetPage(start, count);
        List<Category> cs = categoryService.list();
        return JSONObject.toJSON(cs).toString();
    }


    /* Restful */

    @RequestMapping("/listCategoryRestful")
    public ModelAndView listCategoryRestful(Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());

        ModelAndView modelAndView = new ModelAndView("listCategoryRestful");
        List<Category> cs = categoryService.list();
        page.calculateLast((int) new PageInfo<>(cs).getTotal());
        modelAndView.addObject("cs", cs);

        return modelAndView;
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteCategoryRestful(int id) {
        int delete = categoryService.delete(id);
        System.out.println("CategoryRestful() ... delete = [" + delete + "]");

        return new ModelAndView("redirect:/listCategoryRestful?start=" + new PageInfo<>(categoryService.list()).getPages());
    }

    @RequestMapping(value="/category", method=RequestMethod.PUT)
    public ModelAndView addCategoryRestful(Category category){
        System.out.println("category.getName():"+category.getName());
        categoryService.add(category);

        List<Category> cs = categoryService.list();
        return new ModelAndView("redirect:/listCategoryRestful?start=" + (int) new PageInfo<>(cs).getTotal());
    }

    @RequestMapping(value="/category/{id}",method=RequestMethod.POST)
    public ModelAndView updateCategoryRestful(Category category){
        categoryService.update(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategoryRestful");
        return mav;
    }


}
