package main.domain.strategy;

import main.domain.entities.Scrim;
import main.domain.entities.Usuario;
import java.util.List;

// --- LÓGICA AGREGADA ---
// 1. Asegúrate que implemente la interfaz
public class ByLatencyStrategy implements MatchmakingStrategy {

    @Override
    public List<Usuario> seleccionar(List<Usuario> candidatos, Scrim scrim) {
        // --- SIMULACIÓN ---
        // 2. No necesitamos la lógica real, solo demostrar el patrón.
        System.out.println("[STRATEGY]: Verificando latencia (Max: " + scrim.getLatenciaMax() + "ms)...");
        // En un caso real, filtraríamos la lista. Para la simulación, los aceptamos a todos.
        return candidatos;
    }
}