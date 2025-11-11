package main.infra.notificacion.adapters;

public class JavaMail {

    public void simularEnvio(String mensaje) {
        // Simulación de conexión al servicio SMTP
        System.out.println("[ADAPTEE: JavaMail] >>> ENVIANDO EMAIL: " + mensaje);
    }

}