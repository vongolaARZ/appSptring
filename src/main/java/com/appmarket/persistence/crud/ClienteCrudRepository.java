package com.appmarket.persistence.crud;

import com.appmarket.persistence.entity.Cliente;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteCrudRepository extends CrudRepository<Cliente,Integer> {

    List<Cliente> findAll();
    Cliente getByIdCliente(int idCliente);

    @Query(value = "SELECT a FROM Cliente a ORDER BY a.nombre ASC ")
    List<Cliente> getByName();


}
