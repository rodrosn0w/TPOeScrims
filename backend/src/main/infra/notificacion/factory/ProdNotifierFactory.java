package main.infra.notificacion.factory;

import main.infra.notificacion.INotifier;
import main.infra.notificacion.PushNotifier;
import main.infra.notificacion.adapters.PushService;
// --- LÓGICA AGREGADA ---
import main.infra.notificacion.EmailNotifier;
import main.infra.notificacion.DiscordNotifier;
import main.infra.notificacion.adapters.JavaMail;
import main.infra.notificacion.adapters.DiscordService;
// --- FIN LÓGICA AGREGADA ---

public class ProdNotifierFactory implements NotifierFactory {

    @Override
    public INotifier createPushNotifier() {
        return new PushNotifier(new PushService());
    }

    @Override
    public INotifier createEmailNotifier() {
        // --- LÓGICA MODIFICADA ---
        // Ahora usamos las clases reales
        return new EmailNotifier(new JavaMail());
    }

    @Override
    public INotifier createChatNotifier() {
        // --- LÓGICA MODIFICADA ---
        // Ahora usamos las clases reales
        return new DiscordNotifier(new DiscordService());
    }
}