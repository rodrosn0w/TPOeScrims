package main.domain.builder;

import main.domain.entities.Scrim;

import java.time.LocalDateTime;

public class ScrimBuilder {
    private final Scrim s = new Scrim();
    public ScrimBuilder juego(String j){ s.setJuego(j); return this; }
    public ScrimBuilder formato(String f){ s.setFormato(f); return this; }
    public ScrimBuilder region(String r){ s.setRegion(r); return this; }
    public ScrimBuilder rangos(String min, String max){ s.setRangos(min, max); return this; }
    public ScrimBuilder latenciaMax(int l){ s.setLatenciaMax(l); return this; }
    public ScrimBuilder fecha(LocalDateTime t){ s.setFechaHora(t); return this; }
    public Scrim build(){ /* TODO validar invariantes */ return s; }
}
