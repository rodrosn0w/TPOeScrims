package main.domain.state;

import main.domain.entities.Usuario;

public class StateFinalizado implements ScrimState { // Asegúrate que implemente ScrimState

    @Override
    public void postular(ScrimContext ctx, Usuario u) {
        System.out.println("[STATE: Finalizado] No se puede postular: el scrim ya ha finalizado.");
    }

    @Override
    public void confirmar(ScrimContext ctx, Usuario u) {
        System.out.println("[STATE: Finalizado] No se puede confirmar: el scrim ya ha finalizado.");
    }

    @Override
    public void iniciar(ScrimContext ctx) {
        System.out.println("[STATE: Finalizado] No se puede iniciar: el scrim ya ha finalizado.");
    }

    @Override
    public void finalizar(ScrimContext ctx) {
        System.out.println("[STATE: Finalizado] El scrim ya está finalizado.");
    }

    @Override
    public void cancelar(ScrimContext ctx) {
        System.out.println("[STATE: Finalizado] No se puede cancelar: el scrim ya ha finalizado.");
    }

    @Override
    public String nombre() {
        return "Finalizado";
    }
}