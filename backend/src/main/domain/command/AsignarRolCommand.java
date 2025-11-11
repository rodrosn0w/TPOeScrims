package main.domain.command;

import main.domain.state.ScrimContext;
// (Importarías Usuario y Rol si fueran necesarios)
// import main.domain.entities.Usuario;

/**
 * --- PATRÓN COMMAND (Comando Concreto 1) ---
 * Encapsula la acción de asignar un rol a un jugador.
 */
public class AsignarRolCommand implements ScrimCommand {


    // private final Usuario usuario;
    // private final String nuevoRol;
    // private String rolAnterior; // Para el undo()

    // Constructor para pasar el contexto
    // public AsignarRolCommand(Usuario usuario, String nuevoRol) {
    //     this.usuario = usuario;
    //     this.nuevoRol = nuevoRol;
    // }

    @Override
    public void execute(ScrimContext ctx) {
        // --- SIMULACIÓN ---
        // 1. Guardar el estado anterior para el undo
        // rolAnterior = usuario.getRol();

        // 2. Ejecutar la acción
        // usuario.setRol(nuevoRol);

        System.out.println("[COMMAND]: Ejecutando AsignarRolCommand...");
    }

    @Override
    public void undo(ScrimContext ctx) {
        // 3. Revertir la acción
        // usuario.setRol(rolAnterior);
        System.out.println("[COMMAND]: Deshaciendo AsignarRolCommand...");
    }
}