package main.service;

import main.domain.builder.ScrimBuilder;
import main.domain.entities.Scrim;
import main.domain.events.DomainEventBus;
import main.domain.state.ScrimContext;
import main.repo.InMemoryScrimRepo;
// --- LÓGICA AGREGADA ---
import main.domain.strategy.ByMMRStrategy; // Importa una estrategia concreta

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class ScrimService {
    private final InMemoryScrimRepo repo;
    private final DomainEventBus bus;

    public ScrimService(InMemoryScrimRepo repo, DomainEventBus bus){
        this.repo = repo; this.bus = bus;
    }

    public ScrimContext crearScrim(String juego, String region){
        Scrim s = new ScrimBuilder().juego(juego).formato("5v5").region(region)
                .fecha(LocalDateTime.now().plusHours(2)).build();


        // Asignamos una estrategia por defecto al Scrim
        s.setEstrategiaEmparejamiento(new ByMMRStrategy());
        System.out.println("[SERVICE]: Scrim creado con estrategia por defecto: ByMMRStrategy");


        repo.save(s);
        return new ScrimContext(s, bus);
    }

    public Optional<ScrimContext> cargar(UUID id){
        return repo.findById(id).map(s -> new ScrimContext(s, bus));
    }
}