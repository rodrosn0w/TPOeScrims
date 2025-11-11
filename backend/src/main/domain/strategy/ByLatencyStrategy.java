package main.domain.strategy;

import main.domain.entities.Scrim;
import main.domain.entities.Usuario;
import java.util.List;


// 1. Asegúrate que implemente la interfaz
public class ByLatencyStrategy implements MatchmakingStrategy {

    @Override
    public List<Usuario> seleccionar(List<Usuario> candidatos, Scrim scrim) {
        // --- SIMULACIÓN ---

        System.out.println("[STRATEGY]: Verificando latencia (Max: " + scrim.getLatenciaMax() + "ms)...");
        // En un caso real, filtraríamos la lista. Para la simulación, los aceptamos a todos.
        return candidatos;
    }
}