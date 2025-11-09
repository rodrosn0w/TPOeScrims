package main.infra.notificacion.factory;

import main.infra.notificacion.INotifier;
import main.infra.notificacion.model.Notificacion;

/**
 * --- FÁBRICA CONCRETA 1 (Simulación) ---
 * Esta fábrica crea notificadores "fake" que solo imprimen por consola.
 * Es perfecta para tu demo y para los tests unitarios.
 */
public class DevNotifierFactory implements NotifierFactory {

    @Override
    public INotifier createPushNotifier() {
        // Devolvemos un objeto "al vuelo" que cumple con la interfaz INotifier
        return new INotifier() {
            @Override
            public void send(Notificacion n) {
                System.out.println("[DEV PUSH FAKE]: " + n.mensaje());
            }
        };
    }

    @Override
    public INotifier createEmailNotifier() {
        return new INotifier() {
            @Override
            public void send(Notificacion n) {
                System.out.println("[DEV EMAIL FAKE]: " + n.mensaje());
            }
        };
    }

    @Override
    public INotifier createChatNotifier() {
        return new INotifier() {
            @Override
            public void send(Notificacion n) {
                System.out.println("[DEV CHAT FAKE]: " + n.mensaje());
            }
        };
    }
}