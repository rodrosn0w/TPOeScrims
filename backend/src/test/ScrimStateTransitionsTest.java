package test;

import main.domain.entities.Usuario;
import main.domain.events.DomainEventBus;
import main.domain.state.ScrimContext;
import main.service.ScrimService;
import main.repo.InMemoryScrimRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * --- TEST UNITARIO 3 (Sugerido por la consigna) ---
 * Prueba las transiciones del Patrón State.
 */
class ScrimStateTransitionsTest {

    private ScrimContext ctx;
    private ScrimService service;

    @BeforeEach
    void setUp() {

        DomainEventBus bus = new DomainEventBus();
        InMemoryScrimRepo repo = new InMemoryScrimRepo();
        service = new ScrimService(repo, bus);
        ctx = service.crearScrim("TestGame", "TestRegion");
    }

    @Test
    void scrimIniciaEnEstadoBuscando() {

        String nombreEstado = ctx.getNombreEstadoActual();

        assertEquals("Buscando Jugadores", nombreEstado, "El estado inicial debería ser 'Buscando Jugadores'");
    }

    @Test
    void scrimTransicionaALobbyArmadoCuandoSeLlena() {

        int cupos = ctx.getScrim().getCupos();
        assertEquals(10, cupos, "El formato 5v5 debería tener 10 cupos");

        for(int i = 1; i <= cupos; i++) {
            ctx.postular(new Usuario("jugador" + i, "j" + i + "@uade.edu"));
        }

        String nombreEstado = ctx.getNombreEstadoActual();
        assertEquals("Lobby Armado", nombreEstado, "El estado debería ser 'Lobby Armado' al llenarse");
    }

    @Test
    void scrimTransicionaAConfirmadoDespuesDeConfirmaciones() {

        int cupos = ctx.getScrim().getCupos();
        List<Usuario> jugadores = new ArrayList<>();
        for(int i = 1; i <= cupos; i++) {
            Usuario u = new Usuario("jugador" + i, "j" + i + "@uade.edu");
            jugadores.add(u);
            ctx.postular(u);
        }

        assertEquals("Lobby Armado", ctx.getNombreEstadoActual());


        for(Usuario u : jugadores) {
            ctx.confirmar(u);
        }


        assertEquals("Confirmado", ctx.getNombreEstadoActual());
    }
}