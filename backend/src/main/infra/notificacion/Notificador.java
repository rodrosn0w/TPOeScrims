package main.infra.notificacion;

import main.infra.notificacion.model.Notificacion;

public class Notificador {
    private final INotifier notifier;
    public Notificador(INotifier notifier){ this.notifier = notifier; }
    public void enviar(Notificacion n){ notifier.send(n); }
}