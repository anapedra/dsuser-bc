package com.anapazsatanas.dsuser.clientRepository;

import com.anapazsatanas.dsuser.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
