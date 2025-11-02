package main.domain.state;


import main.domain.entities.Usuario;

public interface ScrimState {
    void postular(ScrimContext ctx, Usuario u);
    void confirmar(ScrimContext ctx, Usuario u);
    void iniciar(ScrimContext ctx);
    void finalizar(ScrimContext ctx);
    void cancelar(ScrimContext ctx);
    String nombre();
}