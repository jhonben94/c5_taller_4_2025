package main.java.py.edu.ucom.taller.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import main.java.py.edu.ucom.taller.services.PlayerService;
import py.edu.ucom.taller.models.results.RespuestaGenerica;

import py.edu.ucom.taller.models.entities.Players;
import jakarta.inject.Inject;

import java.util.List;

@Path("api/players")
public class PlayersResource {
    PlayerService service;

    @Inject
    PlayerService serviceInject;

    public PlayersResource(PlayerService service2) {
        service = service2;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Players> jsonExample() {
        return this.service.obtener();
    }

    @GET
    @Path("/inject")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Players> jsonExample2() {
        return this.serviceInject.obtener();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Players guardar(Players data) {
        return this.service.guardar(data);
    }

}