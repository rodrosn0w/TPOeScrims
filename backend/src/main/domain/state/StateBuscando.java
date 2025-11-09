package main.domain.state;

import main.domain.entities.Postulacion;
import main.domain.entities.Usuario;
import java.util.List; // Agregado

public class StateBuscando implements ScrimState {

    @Override
    public void postular(ScrimContext ctx, Usuario u) {
        // --- LÓGICA MODIFICADA ---
        // CU4 (Postularse) y CU5 (Emparejar)

        // 1. Usamos el Patrón Strategy para validar al jugador
        List<Usuario> candidatos = List.of(u);
        List<Usuario> aceptados = ctx.getScrim().getEstrategiaEmparejamiento().seleccionar(candidatos, ctx.getScrim());

        if (aceptados.isEmpty()) {
            System.out.println("[STATE: Buscando] Jugador " + u.getUsername() + " RECHAZADO por la estrategia.");
            return; // No se postula
        }

        // 2. Si es aceptado, se postula
        System.out.println("[STATE: Buscando] Jugador " + u.getUsername() + " ACEPTADO. Se ha postulado.");
        Postulacion p = new Postulacion(u, ctx.getScrim(), "Cualquiera");
        ctx.agregarPostulacion(p);

        // 3. Verificamos si se llenó el cupo
        if (ctx.getScrim().getCantidadJugadores() == ctx.getScrim().getCupos()) {
            System.out.println("[STATE: Buscando] ¡Lobby lleno! Pasando a 'Lobby Armado'.");
            ctx.setState(new StateLobbyArmado());
        }
        // --- FIN LÓGICA MODIFICADA ---
    }

    // ... (el resto de los métodos quedan igual que en el Paso 2) ...
    @Override
    public void confirmar(ScrimContext ctx, Usuario u) {
        System.out.println("[STATE: Buscando] No se puede confirmar: aún se están buscando jugadores.");
    }
    @Override
    public void iniciar(ScrimContext ctx) {
        System.out.println("[STATE: Buscando] No se puede iniciar: faltan jugadores.");
    }
    @Override
    public void finalizar(ScrimContext ctx) {
        System.out.println("[STATE: Buscando] No se puede finalizar: el scrim no ha comenzado.");
    }
    @Override
    public void cancelar(ScrimContext ctx) {
        ctx.setState(new StateCancelado());
    }
    @Override
    public String nombre() { return "Buscando Jugadores"; }
}