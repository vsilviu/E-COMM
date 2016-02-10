package com.ecomm.controller;

import com.ecomm.dto.ResponseDTO;
import com.ecomm.repository.CategoryRepository;
import com.ecomm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Silviu on 2/10/16.
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "find-all")
    public ResponseDTO findAllCategories() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(categoryService.findAll());
        return responseDTO;
    }

}
