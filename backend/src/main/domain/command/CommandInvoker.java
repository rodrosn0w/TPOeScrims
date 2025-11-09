package main.domain.command;

import main.domain.state.ScrimContext;
import java.util.Stack;

/**
 * --- PATRÓN COMMAND (Invocador) ---
 * Esta clase es el "Invocador". Sabe cómo ejecutar un comando
 * y guarda un historial para poder deshacerlos.
 */
public class CommandInvoker {

    private final Stack<ScrimCommand> historial = new Stack<>();
    private final ScrimContext context; // El invocador conoce el contexto

    public CommandInvoker(ScrimContext context) {
        this.context = context;
    }

    public void executeCommand(ScrimCommand command) {
        command.execute(context);
        historial.push(command); // Lo guardamos para el undo
    }

    public void undoLastCommand() {
        if (!historial.isEmpty()) {
            ScrimCommand lastCommand = historial.pop();
            lastCommand.undo(context);
        } else {
            System.out.println("[COMMAND]: No hay acciones para deshacer.");
        }
    }
}