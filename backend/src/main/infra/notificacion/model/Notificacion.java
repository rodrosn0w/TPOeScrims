package main.infra.notificacion.model;


import java.util.UUID;

public class Notificacion {
    public enum Tipo { INFO, ALERTA }
    private final UUID id = UUID.randomUUID();
    private final String canal;   // "email", "push", "discord"
    private final String mensaje;

    public Notificacion(String canal, String mensaje){
        this.canal = canal; this.mensaje = mensaje;
    }
    public String canal(){ return canal; }
    public String mensaje(){ return mensaje; }
}