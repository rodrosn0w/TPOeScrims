package main.domain.entities;

import java.util.UUID;

public class Postulacion {

    private final UUID id = UUID.randomUUID();
    private final Usuario usuario;
    private final Scrim scrim;
    private final String rolDeseado;
    private String estado; // Pendiente, Aceptada, Rechazada

    public Postulacion(Usuario usuario, Scrim scrim, String rolDeseado) {
        this.usuario = usuario;
        this.scrim = scrim;
        this.rolDeseado = rolDeseado;
        this.estado = "Pendiente";
    }


    public Usuario getUsuario() { return usuario; }
    public Scrim getScrim() { return scrim; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

}