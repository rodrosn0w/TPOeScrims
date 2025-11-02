package main;

import main.controller.ConsoleController;
import main.domain.events.DomainEventBus;
import main.repo.InMemoryScrimRepo;
import main.service.ScrimService;

public class App {
    public static void main(String[] args) {
        var bus = new DomainEventBus();
        var repo = new InMemoryScrimRepo();
        var service = new ScrimService(repo, bus);
        new ConsoleController(service, bus).demo();
    }
}