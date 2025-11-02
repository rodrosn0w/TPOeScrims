package main.infra.notificacion;

import main.infra.notificacion.adapters.IAdapterPush;
import main.infra.notificacion.model.Notificacion;

public class PushNotifier implements INotifier {
    private final IAdapterPush adapter;
    public PushNotifier(IAdapterPush adapter){ this.adapter = adapter; }
    @Override public void send(Notificacion n){ adapter.send(n.mensaje()); }
}