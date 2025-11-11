package main.domain.state;

import main.domain.entities.Confirmacion;
import main.domain.entities.Usuario;

public class StateLobbyArmado implements ScrimState { // Asegúrate que implemente ScrimState

    @Override
    public void postular(ScrimContext ctx, Usuario u) {
        System.out.println("[STATE: Lobby Armado] No se pueden postular jugadores: el lobby está lleno.");
    }

    @Override
    public void confirmar(ScrimContext ctx, Usuario u) {

        // CU6: Confirmar participación
        Confirmacion c = ctx.getConfirmacion(u);

        if (c == null) {
            System.out.println("[STATE: Lobby Armado] El usuario " + u.getUsername() + " no está en este lobby.");
            return;
        }

        if (c.isConfirmado()) {
            System.out.println("[STATE: Lobby Armado] Jugador " + u.getUsername() + " ya había confirmado.");
            return;
        }

        c.confirmar();
        System.out.println("[STATE: Lobby Armado] Jugador " + u.getUsername() + " ha confirmado.");

        // Regla de negocio: Si todos confirmaron, cambia a "Confirmado"
        long totalConfirmados = ctx.getConfirmaciones().stream().filter(Confirmacion::isConfirmado).count();
        if (totalConfirmados == ctx.getScrim().getCupos()) {
            System.out.println("[STATE: Lobby Armado] ¡Todos los jugadores confirmaron! Pasando a 'Confirmado'.");
            ctx.setState(new StateConfirmado());
        } else {
            System.out.println("[STATE: Lobby Armado] Faltan " + (ctx.getScrim().getCupos() - totalConfirmados) + " confirmaciones.");
        }
        // --- FIN LÓGICA AGREGADA ---
    }

    @Override
    public void iniciar(ScrimContext ctx) {
        System.out.println("[STATE: Lobby Armado] No se puede iniciar: faltan confirmaciones.");
    }

    @Override
    public void finalizar(ScrimContext ctx) {
        System.out.println("[STATE: Lobby Armado] No se puede finalizar: el scrim no ha comenzado.");
    }

    @Override
    public void cancelar(ScrimContext ctx) {
        System.out.println("[STATE: Lobby Armado] El scrim ha sido cancelado.");
        ctx.setState(new StateCancelado());
    }

    @Override
    public String nombre() {
        return "Lobby Armado";
    }
}