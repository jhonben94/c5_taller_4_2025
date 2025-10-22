package py.edu.ucom.taller.repository;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.ucom.taller.core.generic.GenericRepository;
import py.edu.ucom.taller.models.entities.Partida;

@ApplicationScoped
public class PartidasRepository extends GenericRepository<Partida, Integer> {

}


