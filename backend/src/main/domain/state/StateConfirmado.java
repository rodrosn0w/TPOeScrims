package main.domain.state;

import main.domain.entities.Usuario;
import java.time.LocalDateTime; // Agregado

public class StateConfirmado implements ScrimState { // Asegúrate que implemente ScrimState

    @Override
    public void postular(ScrimContext ctx, Usuario u) {
        System.out.println("[STATE: Confirmado] No se pueden postular jugadores: el scrim está cerrado y confirmado.");
    }

    @Override
    public void confirmar(ScrimContext ctx, Usuario u) {
        System.out.println("[STATE: Confirmado] El scrim ya fue confirmado por todos.");
    }

    @Override
    public void iniciar(ScrimContext ctx) {

        // CU7: Iniciar scrim
        // Regla de negocio: Solo puede iniciar si la fecha/hora es la actual (simulado por el scheduler)
        if (ctx.getScrim().getFechaHora().isBefore(LocalDateTime.now().plusMinutes(1))) {
            System.out.println("[STATE: Confirmado] ¡El scrim está iniciando! Pasando a 'En Juego'.");
            ctx.setState(new StateEnJuego());
        } else {
            System.out.println("[STATE: Confirmado] No se puede iniciar: aún no es la hora pactada (" + ctx.getScrim().getFechaHora() + ").");
        }
        // --- FIN LÓGICA AGREGADA ---
    }

    @Override
    public void finalizar(ScrimContext ctx) {
        System.out.println("[STATE: Confirmado] No se puede finalizar: el scrim no ha comenzado.");
    }

    @Override
    public void cancelar(ScrimContext ctx) {
        System.out.println("[STATE: Confirmado] El scrim ha sido cancelado (antes de empezar).");
        ctx.setState(new StateCancelado());
    }

    @Override
    public String nombre() {
        return "Confirmado";
    }
}