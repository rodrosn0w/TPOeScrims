package main.domain.command;

import main.domain.state.ScrimContext;

public interface ScrimCommand {
    void execute(ScrimContext ctx);
    void undo(ScrimContext ctx);
}
