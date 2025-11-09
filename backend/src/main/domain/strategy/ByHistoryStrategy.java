package main.domain.strategy;

import main.domain.entities.Scrim;
import main.domain.entities.Usuario;
import java.util.List;

// --- LÓGICA AGREGADA ---
// 1. Asegúrate que implemente la interfaz
public class ByHistoryStrategy implements MatchmakingStrategy {

    @Override
    public List<Usuario> seleccionar(List<Usuario> candidatos, Scrim scrim) {
        // --- SIMULACIÓN ---
        // 2. Simulación de la lógica
        System.out.println("[STRATEGY]: Verificando historial de fair play...");
        // Aceptamos a todos para la simulación.
        return candidatos;
    }
}