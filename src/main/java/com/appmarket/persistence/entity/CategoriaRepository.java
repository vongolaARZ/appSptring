package com.appmarket.persistence.entity;

import com.appmarket.domain.dto.Category;
import com.appmarket.domain.repository.CategoryRepository;
import com.appmarket.persistence.crud.CategoriaCrudRepository;
import com.appmarket.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepository  implements CategoryRepository {

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll(){List<Categoria> categorias = categoriaCrudRepository.findAll();return categoryMapper.toCategorys(categorias);}


}
