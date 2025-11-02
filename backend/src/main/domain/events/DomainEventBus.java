package main.domain.events;

import java.util.ArrayList;
import java.util.List;

public class DomainEventBus {
    private final List<Subscriber> subs = new ArrayList<>();
    public void subscribe(Subscriber s){ subs.add(s); }
    public void publish(DomainEvent e){ subs.forEach(s -> s.onEvent(e)); }
}