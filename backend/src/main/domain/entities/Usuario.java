package main.domain.entities;

import java.util.*;

public class Usuario {
    private UUID id = UUID.randomUUID();
    private String username;
    private String email;
    private String rango;             // simplificado
    private String region;
    private List<String> rolesPreferidos = new ArrayList<>();

    // getters/setters, ctor mínimos
    public Usuario(String username, String email) {
        this.username = username; this.email = email;
    }
    public UUID getId(){ return id; }
    public String getUsername(){ return username; }
    public String getRegion(){ return region; }
    public void setRegion(String r){ this.region = r; }
    public String getRango(){ return rango; }
    public void setRango(String r){ this.rango = r; }
    public List<String> getRolesPreferidos(){ return rolesPreferidos; }
}