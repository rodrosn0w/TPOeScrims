package main.domain.strategy;

import main.domain.entities.Scrim;
import main.domain.entities.Usuario;

import java.util.*;

public interface MatchmakingStrategy {
    List<Usuario> seleccionar(List<Usuario> candidatos, Scrim scrim);
}