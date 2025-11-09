package main.domain.command;

import main.domain.state.ScrimContext;
// import main.domain.entities.Usuario;

/**
 * --- PATRÓN COMMAND (Comando Concreto 2) ---
 * Encapsula la acción de invitar un jugador al Scrim.
 */
public class InvitarJugadorCommand implements ScrimCommand {

    // private final Usuario usuarioAInvitar;

    // public InvitarJugadorCommand(Usuario usuarioAInvitar) {
    //     this.usuarioAInvitar = usuarioAInvitar;
    // }

    @Override
    public void execute(ScrimContext ctx) {
        // --- SIMULACIÓN ---
        // La lógica real sería llamar a ctx.postular(usuarioAInvitar)
        // pero solo si el estado lo permite.
        System.out.println("[COMMAND]: Ejecutando InvitarJugadorCommand...");
        // ctx.postular(usuarioAInvitar);
    }

    @Override
    public void undo(ScrimContext ctx) {
        // La lógica real sería quitar al jugador
        System.out.println("[COMMAND]: Deshaciendo InvitarJugadorCommand...");
        // ctx.quitarJugador(usuarioAInvitar);
    }
}