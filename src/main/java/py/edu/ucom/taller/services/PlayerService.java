package main.java.py.edu.ucom.taller.services;

import jakarta.enterprise.context.ApplicationScoped;
import main.java.py.edu.ucom.taller.repository.PlayerRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import py.edu.ucom.taller.models.entities.Players;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PlayerService {
    PlayerRepository repository;

    public PlayerService(PlayerRepository repository2) {
        repository = repository2;
    }

    public List<Players> obtener() {
        return this.repository.listAll();
    }

    @Transactional
    public Players guardar(Players data) {
        if (data.getIdPlayer() == null) {
            this.repository.persist(data);
            return data;
        } else {
            return this.repository.getEntityManager().merge(data);
        }
    }

}
