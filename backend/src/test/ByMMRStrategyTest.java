package test;

import main.domain.entities.Scrim;
import main.domain.entities.Usuario;
import main.domain.strategy.ByMMRStrategy;
import main.domain.strategy.MatchmakingStrategy;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * --- TEST UNITARIO 2 (Sugerido por la consigna) ---
 * Prueba el Patrón Strategy.
 */
class ByMMRStrategyTest {

    @Test
    void byMMRStrategyAceptaUsuarioValido() {
        // 1. Arrange
        MatchmakingStrategy strategy = new ByMMRStrategy();
        Scrim scrim = new Scrim(); // Scrim de simulación
        scrim.setRangos("Oro", "Platino");

        Usuario jugadorValido = new Usuario("jugadorOro", "oro@uade.edu");
        jugadorValido.setRango("Oro");

        List<Usuario> candidatos = List.of(jugadorValido);

        // 2. Act
        List<Usuario> aceptados = strategy.seleccionar(candidatos, scrim);

        // 3. Assert
        // Como nuestra estrategia simulada acepta a todos, verificamos que la lista no esté vacía.
        assertFalse(aceptados.isEmpty(), "El jugador válido debería haber sido aceptado");
        assertEquals(1, aceptados.size(), "Debería haber 1 jugador aceptado");
        assertEquals("jugadorOro", aceptados.get(0).getUsername());
    }
}
