package com.ecomm.service.impl;

import com.ecomm.entity.NomCategory;
import com.ecomm.repository.CategoryRepository;
import com.ecomm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Silviu on 2/10/16.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<NomCategory> findAll() {
        return categoryRepository.findAll();
    }
}
