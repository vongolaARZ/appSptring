package com.appmarket.persistence.crud;

import com.appmarket.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Integer>{

    List<Categoria> findAll();




}
