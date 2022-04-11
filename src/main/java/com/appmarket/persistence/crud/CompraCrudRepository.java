package com.appmarket.persistence.crud;

import com.appmarket.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra,Integer> {

    List<Compra> findAll();
    Optional<List<Compra>> findByIdCliente (String idCliente);


}
