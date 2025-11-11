package main.infra.notificacion;

import main.infra.notificacion.adapters.JavaMail; // Importa el Adaptee
import main.infra.notificacion.model.Notificacion;


public class EmailNotifier implements INotifier { // 1. Implementa la interfaz

    private final JavaMail adapter; // 2. Depende del servicio (Adaptee)

    public EmailNotifier(JavaMail adapter) {
        this.adapter = adapter;
    }

    @Override
    public void send(Notificacion n) {

        System.out.println("[ADAPTER: Email] Traduciendo notificación genérica a email...");
        // adapter.sendEmail(n.getDestinatario(), "Notificación de Scrim", n.mensaje());
        adapter.simularEnvio(n.mensaje()); // Usamos un método simulado
    }
}