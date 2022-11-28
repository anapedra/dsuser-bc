package com.anapazsatanas.dsuser.clientRepository;

import com.anapazsatanas.dsuser.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
