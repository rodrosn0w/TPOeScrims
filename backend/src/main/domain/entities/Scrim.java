package main.domain.entities;

import main.domain.strategy.MatchmakingStrategy;
import java.time.LocalDateTime;
import java.util.*;

public class Scrim {
    private UUID id = UUID.randomUUID();
    private String juego;
    private String formato;
    private String region;
    private String rangoMin;
    private String rangoMax;
    private int latenciaMax;
    private LocalDateTime fechaHora;
    private List<Usuario> jugadores = new ArrayList<>();


    // Atributo clave para el Patrón State.
    private int cupos = 10; // Valor por defecto para 5v5

    private MatchmakingStrategy estrategiaEmparejamiento;

    public UUID getId(){ return id; }
    public String getJuego(){ return juego; }
    public String getRegion(){ return region; }
    public List<Usuario> getJugadores(){ return jugadores; }


    public int getCupos() { return cupos; }
    public int getLatenciaMax() { return latenciaMax; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public int getCantidadJugadores() { return jugadores.size(); } // Necesario para StateBuscando

    public MatchmakingStrategy getEstrategiaEmparejamiento(){ return estrategiaEmparejamiento; }
    public void setEstrategiaEmparejamiento(MatchmakingStrategy e){ this.estrategiaEmparejamiento = e; }

    public void setJuego(String j){ this.juego = j; }
    public void setFormato(String f){
        this.formato = f;

        if ("5v5".equals(f)) this.cupos = 10;
        if ("1v1".equals(f)) this.cupos = 2;
    }
    public void setRegion(String r){ this.region = r; }
    public void setRangos(String min, String max){ this.rangoMin = min; this.rangoMax = max; }
    public void setLatenciaMax(int l){ this.latenciaMax = l; }
    public void setFechaHora(LocalDateTime t){ this.fechaHora = t; }


    public void agregarJugador(Usuario u) {
        if (jugadores.size() < cupos) {
            jugadores.add(u);
        }
    }
}