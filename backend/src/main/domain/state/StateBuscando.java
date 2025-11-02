package main.domain.state;

import main.domain.entities.Usuario;

public class StateBuscando implements ScrimState {
    @Override public void postular(ScrimContext ctx, Usuario u) { /* TODO */ }
    @Override public void confirmar(ScrimContext ctx, Usuario u) { /* ignore */ }
    @Override public void iniciar(ScrimContext ctx) { /* valida cupo => setState(new StateLobbyArmado()) */ }
    @Override public void finalizar(ScrimContext ctx) { /* no aplica */ }
    @Override public void cancelar(ScrimContext ctx) { ctx.setState(new StateCancelado()); }
    @Override public String nombre() { return "Buscando"; }
}
