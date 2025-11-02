package main.controller;

import main.domain.entities.Usuario;
import main.domain.events.DomainEventBus;
import main.domain.events.ScrimStateChanged;
import main.infra.notificacion.INotifier;
import main.infra.notificacion.Notificador;
import main.infra.notificacion.PushNotifier;
import main.infra.notificacion.adapters.PushService;
import main.infra.notificacion.model.Notificacion;
import main.service.ScrimService;

public class ConsoleController {
    private final ScrimService service;
    private final DomainEventBus bus;

    public ConsoleController(ScrimService service, DomainEventBus bus){
        this.service = service; this.bus = bus;
        // suscriptor de ejemplo → envía “push” al cambiar estado
        INotifier push = new PushNotifier(new PushService());
        bus.subscribe(e -> {
            if(e instanceof ScrimStateChanged ev){
                new Notificador(push).enviar(new Notificacion("push",
                        "Scrim " + ev.scrimId() + " -> " + ev.nuevoEstado()));
            }
        });
    }

    public void demo() {
        var ctx = service.crearScrim("Valorant", "SA");
        ctx.iniciar(); // solo para disparar eventos de ejemplo
        ctx.cancelar();
        ctx.postular(new Usuario("rodri","r@uade.edu"));
        System.out.println("Demo finalizada.");
    }
}