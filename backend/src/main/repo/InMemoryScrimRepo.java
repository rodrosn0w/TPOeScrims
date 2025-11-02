package main.repo;

import main.domain.entities.Scrim;

import java.util.*;

public class InMemoryScrimRepo {
    private final Map<UUID, Scrim> data = new HashMap<>();
    public Scrim save(Scrim s){ data.put(s.getId(), s); return s; }
    public Optional<Scrim> findById(UUID id){ return Optional.ofNullable(data.get(id)); }
    public List<Scrim> findAll(){ return new ArrayList<>(data.values()); }
}
