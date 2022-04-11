package com.appmarket.persistence.crud;

import com.appmarket.persistence.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends JpaRepository<Compra,Integer> {


    Optional<List<Compra>> findByIdCliente (String idCliente);


}
