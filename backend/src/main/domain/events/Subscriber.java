package main.domain.events;

public interface Subscriber { void onEvent(DomainEvent e); }