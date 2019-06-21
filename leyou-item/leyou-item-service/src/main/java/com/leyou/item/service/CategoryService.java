package com.leyou.item.service;


import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根绝ParenId查询子类目
     * */
   public List<Category> queryCategoryiesByPid(Long pid){
       Category record=new Category();
       record.setIsParentId(pid);
       return categoryMapper.select(record);
   }
}
