package domain.factory;

public interface NotifierFactory {
    interface Notifier { void send(String msg); }
    Notifier createPush();
    Notifier createEmail();
    Notifier createChat();
}

