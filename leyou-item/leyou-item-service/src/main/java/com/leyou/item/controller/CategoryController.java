package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /*
     * 根据父id来查询分类信息
     * */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryiesByPid(@RequestParam(value = "pid",defaultValue = "0") Long pid){
        if(pid==null || pid.longValue()<0){
            return ResponseEntity.badRequest().build();
        }
        List<Category> categories=categoryService.queryCategoryiesByPid(pid);
        if(categories==null|| categories.size()==0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categories);
    }

}
