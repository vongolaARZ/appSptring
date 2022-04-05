package com.appmarket.persistence.entity;

import com.appmarket.domain.dto.Client;
import com.appmarket.domain.repository.ClientRepository;
import com.appmarket.persistence.crud.ClienteCrudRepository;
import com.appmarket.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRespository implements ClientRepository {


 @Autowired
 private ClienteCrudRepository clienteCrudRepository;

 @Autowired
 private ClientMapper clientMapper;

    @Override
    public List<Client> getAll(){List<Cliente> clientes = clienteCrudRepository.findAll();return clientMapper.toClients(clientes);}

    @Override
    public Client getByClientId(int clientId) {Cliente cliente = clienteCrudRepository.getByIdCliente(clientId);return clientMapper.toClient(cliente);}

    public List<Client> getByName(){List<Cliente> clientes = clienteCrudRepository.getByName();return clientMapper.toClients(clientes);}

















}
