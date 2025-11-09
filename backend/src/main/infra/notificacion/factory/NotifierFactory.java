package main.infra.notificacion.factory;


import main.infra.notificacion.INotifier;

/**
 * --- PATRÓN ABSTRACT FACTORY ---
 * Esta es la interfaz abstracta de la fábrica.
 * Define los métodos para crear la familia de productos (los notificadores).
 * Tu ConsoleController solo conocerá esta interfaz.
 */
public interface NotifierFactory {
    INotifier createPushNotifier();
    INotifier createEmailNotifier();
    INotifier createChatNotifier();
}