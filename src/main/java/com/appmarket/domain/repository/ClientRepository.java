package com.appmarket.domain.repository;

import com.appmarket.domain.dto.Client;


import java.util.List;

public interface ClientRepository {

    List<Client> getAll();
    Client getByClientId(int clientId);
    List<Client> getByName();



}
