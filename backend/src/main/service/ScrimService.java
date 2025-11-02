package main.service;

import main.domain.builder.ScrimBuilder;
import main.domain.entities.Scrim;
import main.domain.events.DomainEventBus;
import main.domain.state.ScrimContext;
import main.repo.InMemoryScrimRepo;

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
        repo.save(s);
        return new ScrimContext(s, bus);
    }

    public Optional<ScrimContext> cargar(UUID id){
        return repo.findById(id).map(s -> new ScrimContext(s, bus));
    }
}