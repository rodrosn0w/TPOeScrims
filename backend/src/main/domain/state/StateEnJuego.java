package main.domain.state;

import main.domain.entities.Usuario;

public class StateEnJuego implements ScrimState { // Asegúrate que implemente ScrimState

    @Override
    public void postular(ScrimContext ctx, Usuario u) {
        System.out.println("[STATE: En Juego] No se pueden postular jugadores: el scrim está en curso.");
    }

    @Override
    public void confirmar(ScrimContext ctx, Usuario u) {
        System.out.println("[STATE: En Juego] No se pueden confirmar jugadores: el scrim está en curso.");
    }

    @Override
    public void iniciar(ScrimContext ctx) {
        System.out.println("[STATE: En Juego] El scrim ya ha sido iniciado.");
    }

    @Override
    public void finalizar(ScrimContext ctx) {
        // --- LÓGICA AGREGADA ---
        // CU8: Finalizar y cargar estadísticas
        System.out.println("[STATE: En Juego] El scrim ha finalizado. Pasando a 'Finalizado'.");
        ctx.setState(new StateFinalizado());
        // Aquí se dispararía otro evento para que el sistema pida las estadísticas.
        // --- FIN LÓGICA AGREGADA ---
    }

    @Override
    public void cancelar(ScrimContext ctx) {
        System.out.println("[STATE: En Juego] No se puede cancelar: el scrim ya está en curso.");
    }

    @Override
    public String nombre() {
        return "En Juego";
    }
}