package com.appmarket.persistence.mapper;

import com.appmarket.domain.dto.Client;
import com.appmarket.persistence.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "idCliente",target = "clientId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "apellido",target = "lastName"),
            @Mapping(source = "celular",target = "phone"),
            @Mapping(source = "direccion",target = "adress"),
            @Mapping(source = "correoElectronico",target = "eMail")
    })
    Client toClient(Cliente cliente);

    List<Client> toClients(List<Cliente> clientes);

}
