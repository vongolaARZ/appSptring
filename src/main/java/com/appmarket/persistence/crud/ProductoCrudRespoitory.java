package com.appmarket.persistence.crud;

import com.appmarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRespoitory  extends CrudRepository<Producto,Integer> {

    List<Producto> findAll();
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findAllByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);


    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad, boolean b);
}
