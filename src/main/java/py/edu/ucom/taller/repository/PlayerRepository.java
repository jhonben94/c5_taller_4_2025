package main.java.py.edu.ucom.taller.repository;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import py.edu.ucom.taller.models.entities.Players;

@ApplicationScoped
public class PlayerRepository implements PanacheRepository<Players> {
    
}
