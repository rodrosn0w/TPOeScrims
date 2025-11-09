package main.controller;

import main.domain.command.ScrimCommand;
import main.domain.entities.Usuario;
import main.domain.events.DomainEventBus;
import main.domain.events.ScrimStateChanged;
import main.infra.notificacion.INotifier;
import main.infra.notificacion.Notificador;
import main.infra.notificacion.factory.NotifierFactory;
import main.infra.notificacion.model.Notificacion;
import main.service.ScrimService;
// --- LÓGICA AGREGADA (Imports para la demo) ---
import main.domain.command.AsignarRolCommand;
import main.domain.command.CommandInvoker;
import main.domain.state.ScrimContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
// --- FIN LÓGICA AGREGADA ---

public class ConsoleController {
    private final ScrimService service;
    private final DomainEventBus bus;
    private final NotifierFactory factory;

    // El constructor queda igual que como lo dejamos en el Paso 1
    public ConsoleController(ScrimService service, DomainEventBus bus, NotifierFactory factory){
        this.service = service;
        this.bus = bus;
        this.factory = factory;

        // El suscriptor (Observer) usa la Factory para crear los Notifiers (Adapter)
        INotifier pushNotifier = factory.createPushNotifier();
        INotifier emailNotifier = factory.createEmailNotifier();
        INotifier chatNotifier = factory.createChatNotifier();

        bus.subscribe(e -> {
            if(e instanceof ScrimStateChanged ev){
                String msg = "Scrim " + ev.scrimId() + " -> " + ev.nuevoEstado();

                // Disparamos todas las notificaciones
                new Notificador(pushNotifier).enviar(new Notificacion("push", msg));
                new Notificador(emailNotifier).enviar(new Notificacion("email", msg));
                new Notificador(chatNotifier).enviar(new Notificacion("chat", msg));
            }
        });
    }

    /**
     * Esta es la demo principal que simula el flujo completo
     * para el video de 5 minutos.
     */
    public void demo() {
        System.out.println("--- INICIO DE LA DEMO: eScrims ---");

        // --- 1. CU3: Crear Scrim (Patrón Builder) ---
        System.out.println("\n--- PASO 1: Creando Scrim (Patrón Builder) ---");
        ScrimContext ctx = service.crearScrim("Valorant", "SA");
        // (El service ya asignó la Strategy por defecto)

        // --- 2. CU4/CU5: Postular Jugadores (Patrón State + Strategy) ---
        System.out.println("\n--- PASO 2: Postulando jugadores (Patrones State y Strategy) ---");

        // Creamos 10 usuarios de simulación
        List<Usuario> jugadores = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            jugadores.add(new Usuario("jugador" + i, "j" + i + "@uade.edu"));
        }

        // Postulamos a los primeros 9
        for(int i = 0; i < 9; i++) {
            ctx.postular(jugadores.get(i));
        }

        System.out.println("\n--- Postulando al 10mo jugador (dispara cambio de estado) ---");
        // Al postular al 10mo, el StateBuscando debe transicionar a StateLobbyArmado
        ctx.postular(jugadores.get(9));
        // (Esto debe disparar al Observer, Factory y Adapters por primera vez)

        // --- 3. CU6: Confirmar Participación (Patrón State) ---
        System.out.println("\n--- PASO 3: Confirmando participación (Patrón State) ---");

        // Confirmamos los primeros 9
        for(int i = 0; i < 9; i++) {
            ctx.confirmar(jugadores.get(i));
        }

        System.out.println("\n--- Confirmando al 10mo jugador (dispara cambio de estado) ---");
        // Al confirmar al 10mo, el StateLobbyArmado debe transicionar a StateConfirmado
        ctx.confirmar(jugadores.get(9));
        // (Esto dispara al Observer, Factory y Adapters por segunda vez)

        // --- 4. CU7: Iniciar Scrim (Patrón State) ---
        System.out.println("\n--- PASO 4: Iniciando Scrim (Patrón State) ---");

        // Simulación: El Scheduler corre y ve que es la hora.
        // "Hackeamos" la hora del scrim para que coincida con la hora actual.
        System.out.println("... (Simulación: El Scheduler detecta que es la hora de la partida) ...");
        ctx.getScrim().setFechaHora(LocalDateTime.now().minusMinutes(1)); // Seteamos la hora a "ahora"

        ctx.iniciar();
        // (Esto dispara al Observer, Factory y Adapters por tercera vez)

        // --- 5. CU8: Finalizar Scrim (Patrón State) ---
        System.out.println("\n--- PASO 5: Finalizando Scrim (Patrón State) ---");
        ctx.finalizar();
        // (Esto dispara al Observer, Factory y Adapters por cuarta vez)

        // --- 6. Demostración Patrón Command (Opcional) ---
        System.out.println("\n--- PASO 6: Demostración Patrón Command (Opcional) ---");
        CommandInvoker invoker = new CommandInvoker(ctx);

        // Creamos y ejecutamos un comando
        ScrimCommand asignarRol = new AsignarRolCommand();
        invoker.executeCommand(asignarRol);

        // Deshacemos el comando
        invoker.undoLastCommand();

        System.out.println("\n--- FIN DE LA DEMO ---");
    }
}