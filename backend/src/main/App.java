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



        NotifierFactory factory = new DevNotifierFactory();


        new ConsoleController(service, bus, factory).demo();
    }
}