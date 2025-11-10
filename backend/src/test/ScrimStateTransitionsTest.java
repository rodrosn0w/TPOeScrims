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
        // Preparamos un ScrimContext limpio para cada test
        // Esto simula la arquitectura completa
        DomainEventBus bus = new DomainEventBus();
        InMemoryScrimRepo repo = new InMemoryScrimRepo();
        service = new ScrimService(repo, bus);
        ctx = service.crearScrim("TestGame", "TestRegion");
    }

    @Test
    void scrimIniciaEnEstadoBuscando() {
        // 1. Arrange (Hecho en setUp)
        // 2. Act
        String nombreEstado = ctx.getNombreEstadoActual(); // Usamos el getter nuevo

        // 3. Assert
        // Verificamos que el estado inicial sea "Buscando Jugadores"
        assertEquals("Buscando Jugadores", nombreEstado, "El estado inicial debería ser 'Buscando Jugadores'");
    }

    @Test
    void scrimTransicionaALobbyArmadoCuandoSeLlena() {
        // 1. Arrange
        // (Scrim 5v5 necesita 10 jugadores)
        int cupos = ctx.getScrim().getCupos();
        assertEquals(10, cupos, "El formato 5v5 debería tener 10 cupos");

        // 2. Act
        // Postulamos 10 jugadores
        for(int i = 1; i <= cupos; i++) {
            ctx.postular(new Usuario("jugador" + i, "j" + i + "@uade.edu"));
        }

        // 3. Assert
        // Verificamos que el estado haya cambiado a "Lobby Armado"
        String nombreEstado = ctx.getNombreEstadoActual();
        assertEquals("Lobby Armado", nombreEstado, "El estado debería ser 'Lobby Armado' al llenarse");
    }

    @Test
    void scrimTransicionaAConfirmadoDespuesDeConfirmaciones() {
        // 1. Arrange
        // Llenamos el lobby primero
        int cupos = ctx.getScrim().getCupos();
        List<Usuario> jugadores = new ArrayList<>();
        for(int i = 1; i <= cupos; i++) {
            Usuario u = new Usuario("jugador" + i, "j" + i + "@uade.edu");
            jugadores.add(u);
            ctx.postular(u);
        }
        // En este punto, el estado es "Lobby Armado"
        assertEquals("Lobby Armado", ctx.getNombreEstadoActual());

        // 2. Act
        // Todos los jugadores confirman
        for(Usuario u : jugadores) {
            ctx.confirmar(u);
        }

        // 3. Assert
        // Verificamos que el estado haya cambiado a "Confirmado"
        assertEquals("Confirmado", ctx.getNombreEstadoActual());
    }
}