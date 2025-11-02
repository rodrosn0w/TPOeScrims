package main.domain.state;

import main.domain.entities.Usuario;

public class StateCancelado implements ScrimState {

    @Override
    public void postular(ScrimContext ctx, Usuario u) {
        System.out.println("[CANCELADO] No se pueden postular jugadores: el scrim ha sido cancelado.");
    }

    @Override
    public void confirmar(ScrimContext ctx, Usuario u) {
        System.out.println("[CANCELADO] No se pueden confirmar jugadores: el scrim ha sido cancelado.");
    }

    @Override
    public void iniciar(ScrimContext ctx) {
        System.out.println("[CANCELADO] No se puede iniciar: el scrim ha sido cancelado.");
    }

    @Override
    public void finalizar(ScrimContext ctx) {
        System.out.println("[CANCELADO] No se puede finalizar: el scrim ha sido cancelado.");
    }

    @Override
    public void cancelar(ScrimContext ctx) {
        System.out.println("[CANCELADO] El scrim ya está cancelado.");
    }

    @Override
    public String nombre() {
        return "Cancelado";
    }
}