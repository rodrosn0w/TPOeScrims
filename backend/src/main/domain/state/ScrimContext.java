package main.domain.state;

import main.domain.entities.Confirmacion; // Agregado
import main.domain.entities.Postulacion; // Agregado
import main.domain.entities.Scrim;
import main.domain.entities.Usuario;
import main.domain.events.DomainEventBus;
import main.domain.events.ScrimStateChanged;

import java.util.ArrayList; // Agregado
import java.util.List; // Agregado
import java.util.Objects; // Agregado

public class ScrimContext {
    private final Scrim scrim;
    private ScrimState state;
    private final DomainEventBus bus;


    // El contexto debe manejar las listas para que los estados tomen decisiones
    private final List<Postulacion> postulaciones = new ArrayList<>();
    private final List<Confirmacion> confirmaciones = new ArrayList<>();


    public ScrimContext(Scrim scrim, DomainEventBus bus){
        this.scrim = scrim; this.bus = bus;
        this.state = new StateBuscando();
    }
    public void setState(ScrimState s){
        this.state = s;
        bus.publish(new ScrimStateChanged(scrim.getId(), s.nombre()));
    }
    public Scrim getScrim(){ return scrim; }


    // Métodos para que los estados gestionen las listas
    public List<Postulacion> getPostulaciones() {
        return postulaciones;
    }
    public List<Confirmacion> getConfirmaciones() {
        return confirmaciones;
    }

    // Busca una confirmación por el ID del usuario
    public Confirmacion getConfirmacion(Usuario u) {
        return confirmaciones.stream()
                .filter(c -> Objects.equals(c.getUsuarioId(), u.getId()))
                .findFirst().orElse(null);
    }

    public void agregarPostulacion(Postulacion p) {
        this.postulaciones.add(p);
        this.scrim.agregarJugador(p.getUsuario());
        // Al aceptar una postulación, se crea un slot de confirmación pendiente
        this.confirmaciones.add(new Confirmacion(p.getUsuario(), this.scrim));
    }

    public String getNombreEstadoActual() {
        return this.state.nombre();
    }


    public void postular(Usuario u){ state.postular(this, u); }
    public void confirmar(Usuario u){ state.confirmar(this, u); }
    public void iniciar(){ state.iniciar(this); }
    public void finalizar(){ state.finalizar(this); }
    public void cancelar(){ state.cancelar(this); }
}