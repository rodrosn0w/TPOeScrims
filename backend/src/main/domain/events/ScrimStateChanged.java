package main.domain.events;

import java.util.UUID;

public record ScrimStateChanged(UUID scrimId, String nuevoEstado) implements DomainEvent {}
