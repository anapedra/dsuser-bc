package com.anapazsatanas.dsuser.resources;

import com.anapazsatanas.dsuser.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
