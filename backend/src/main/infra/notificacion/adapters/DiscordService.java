package main.infra.notificacion.adapters;

public class DiscordService {
    public void simularEnvio(String mensaje) {
        // Simulación de envío a la API de Discord
        System.out.println("[ADAPTEE: Discord] >>> ENVIANDO WEBHOOK: " + mensaje);
    }

}