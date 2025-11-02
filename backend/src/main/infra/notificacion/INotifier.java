package main.infra.notificacion;


import main.infra.notificacion.model.Notificacion;

public interface INotifier { void send(Notificacion n); }
