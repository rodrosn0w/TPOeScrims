package main.infra.notificacion.factory;


import main.infra.notificacion.INotifier;


public interface NotifierFactory {
    INotifier createPushNotifier();
    INotifier createEmailNotifier();
    INotifier createChatNotifier();
}