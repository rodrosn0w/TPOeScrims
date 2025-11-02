package main.infra.notificacion.adapters;

public class PushService implements IAdapterPush {
    @Override public void send(String msg) {
        System.out.println("[PUSH] " + msg); // simulación
    }
}
