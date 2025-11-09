package main.domain.command;

import main.domain.state.ScrimContext;
// import main.domain.entities.Usuario;

/**
 * --- PATRÓN COMMAND (Comando Concreto 3) ---
 * Encapsula la acción de intercambiar dos jugadores.
 */
public class SwapJugadoresCommand implements ScrimCommand {

    // private final Usuario jugador1;
    // private final Usuario jugador2;

    // public SwapJugadoresCommand(Usuario j1, Usuario j2) {
    //     this.jugador1 = j1;
    //     this.jugador2 = j2;
    // }

    @Override
    public void execute(ScrimContext ctx) {
        // --- SIMULACIÓN ---
        // La lógica real sería cambiar a j1 al equipo de j2 y viceversa
        System.out.println("[COMMAND]: Ejecutando SwapJugadoresCommand...");
    }

    @Override
    public void undo(ScrimContext ctx) {
        // La lógica real sería volver a intercambiarlos
        System.out.println("[COMMAND]: Deshaciendo SwapJugadoresCommand...");
    }
}