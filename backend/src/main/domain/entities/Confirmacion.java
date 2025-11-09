package main.domain.entities;

import java.util.UUID;

public class Confirmacion {
    // --- LÓGICA AGREGADA ---
    // Atributos del modelo de dominio
    private final UUID id = UUID.randomUUID();
    private final Usuario usuario;
    private final Scrim scrim;
    private boolean confirmado;

    public Confirmacion(Usuario usuario, Scrim scrim) {
        this.usuario = usuario;
        this.scrim = scrim;
        this.confirmado = false; // Inicia sin confirmar
    }

    public void confirmar() {
        this.confirmado = true;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public UUID getUsuarioId() {
        return usuario.getId();
    }
    // --- FIN LÓGICA AGREGADA ---
}