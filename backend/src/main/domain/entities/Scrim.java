package main.domain.entities;

import main.domain.strategy.MatchmakingStrategy;

import java.time.LocalDateTime;
import java.util.*;

public class Scrim {
    private UUID id = UUID.randomUUID();
    private String juego;
    private String formato;                 // 5v5 / 1v1
    private String region;
    private String rangoMin;
    private String rangoMax;
    private int latenciaMax;
    private LocalDateTime fechaHora;
    private List<Usuario> jugadores = new ArrayList<>();

    private MatchmakingStrategy estrategiaEmparejamiento;

    public UUID getId(){ return id; }
    public String getJuego(){ return juego; }
    public String getRegion(){ return region; }
    public List<Usuario> getJugadores(){ return jugadores; }

    public MatchmakingStrategy getEstrategiaEmparejamiento(){ return estrategiaEmparejamiento; }
    public void setEstrategiaEmparejamiento(MatchmakingStrategy e){ this.estrategiaEmparejamiento = e; }

    // setters encadenables para builder si se desea
    public void setJuego(String j){ this.juego = j; }
    public void setFormato(String f){ this.formato = f; }
    public void setRegion(String r){ this.region = r; }
    public void setRangos(String min, String max){ this.rangoMin = min; this.rangoMax = max; }
    public void setLatenciaMax(int l){ this.latenciaMax = l; }
    public void setFechaHora(LocalDateTime t){ this.fechaHora = t; }
}