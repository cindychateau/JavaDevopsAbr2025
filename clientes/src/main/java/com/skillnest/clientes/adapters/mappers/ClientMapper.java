package com.skillnest.clientes.adapters.mappers;

import com.skillnest.clientes.adapters.dto.ClientDTO;
import com.skillnest.clientes.entities.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

	ClientDTO mapFromClient(Client client);

}
