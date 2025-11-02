package main.domain.strategy;

import main.domain.entities.Scrim;
import main.domain.entities.Usuario;

import java.util.*;

public class ByMMRStrategy implements MatchmakingStrategy {
    @Override public List<Usuario> seleccionar(List<Usuario> candidatos, Scrim scrim) {
        // TODO: filtrar por rangoMin/rangoMax
        return candidatos;
    }}
