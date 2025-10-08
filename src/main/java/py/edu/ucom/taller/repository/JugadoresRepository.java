package py.edu.ucom.taller.repository;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.ucom.taller.core.generic.GenericRepository;
import py.edu.ucom.taller.models.entities.Jugador;

@ApplicationScoped
public class JugadoresRepository extends GenericRepository<Jugador, Integer> {

}
