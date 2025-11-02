package main.domain.state;

import main.domain.entities.Scrim;
import main.domain.entities.Usuario;
import main.domain.events.DomainEventBus;
import main.domain.events.ScrimStateChanged;

public class ScrimContext {
    private final Scrim scrim;
    private ScrimState state;
    private final DomainEventBus bus;

    public ScrimContext(Scrim scrim, DomainEventBus bus){
        this.scrim = scrim; this.bus = bus;
        this.state = new StateBuscando();
    }
    public void setState(ScrimState s){
        this.state = s;
        bus.publish(new ScrimStateChanged(scrim.getId(), s.nombre()));
    }
    public Scrim getScrim(){ return scrim; }

    public void postular(Usuario u){ state.postular(this, u); }
    public void confirmar(Usuario u){ state.confirmar(this, u); }
    public void iniciar(){ state.iniciar(this); }
    public void finalizar(){ state.finalizar(this); }
    public void cancelar(){ state.cancelar(this); }
}