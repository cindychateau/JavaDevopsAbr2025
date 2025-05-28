package com.skillnest.clientes.entities.repositories;

import com.skillnest.clientes.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
