package main.infra.notificacion;

import main.infra.notificacion.adapters.DiscordService; // Importa el Adaptee
import main.infra.notificacion.model.Notificacion;

// --- LÓGICA AGREGADA ---
public class DiscordNotifier implements INotifier { // 1. Implementa la interfaz

    private final DiscordService adapter; // 2. Depende del servicio (Adaptee)

    public DiscordNotifier(DiscordService adapter) {
        this.adapter = adapter;
    }

    @Override
    public void send(Notificacion n) {
        // 3. Lógica de "adaptación"
        System.out.println("[ADAPTER: Discord] Traduciendo notificación genérica a webhook...");
        // adapter.sendWebhook("canal-de-scrims", n.mensaje());
        adapter.simularEnvio(n.mensaje()); // Usamos un método simulado
    }
}