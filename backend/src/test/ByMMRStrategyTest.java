package test;

import main.domain.entities.Scrim;
import main.domain.entities.Usuario;
import main.domain.strategy.ByMMRStrategy;
import main.domain.strategy.MatchmakingStrategy;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class ByMMRStrategyTest {

    @Test
    void byMMRStrategyAceptaUsuarioValido() {

        MatchmakingStrategy strategy = new ByMMRStrategy();
        Scrim scrim = new Scrim(); // Scrim de simulación
        scrim.setRangos("Oro", "Platino");

        Usuario jugadorValido = new Usuario("jugadorOro", "oro@uade.edu");
        jugadorValido.setRango("Oro");

        List<Usuario> candidatos = List.of(jugadorValido);


        List<Usuario> aceptados = strategy.seleccionar(candidatos, scrim);


        assertFalse(aceptados.isEmpty(), "El jugador válido debería haber sido aceptado");
        assertEquals(1, aceptados.size(), "Debería haber 1 jugador aceptado");
        assertEquals("jugadorOro", aceptados.get(0).getUsername());
    }
}
