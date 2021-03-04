package com.microservice.commandesservice.dao;

import com.microservice.commandesservice.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeDao extends JpaRepository<Commande, Integer> {
public List<Commande> findAll();


}
