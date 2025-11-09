package main;

import main.controller.ConsoleController;
import main.domain.events.DomainEventBus;
// Importamos las factories
import main.infra.notificacion.factory.DevNotifierFactory;
import main.infra.notificacion.factory.NotifierFactory;
import main.repo.InMemoryScrimRepo;
import main.service.ScrimService;

public class App {
    public static void main(String[] args) {
        var bus = new DomainEventBus();
        var repo = new InMemoryScrimRepo();
        var service = new ScrimService(repo, bus);

        // --- ¡CAMBIO AQUÍ! ---
        // 1. Decidimos qué fábrica usar (la de simulación para la demo)
        NotifierFactory factory = new DevNotifierFactory();

        // 2. Se la "inyectamos" al controlador
        new ConsoleController(service, bus, factory).demo();
    }
}