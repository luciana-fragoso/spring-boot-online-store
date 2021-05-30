package com.demo.OnlineStore.Repository;


import com.demo.OnlineStore.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
