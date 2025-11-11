package test;



import main.infra.notificacion.INotifier;
import main.infra.notificacion.factory.DevNotifierFactory;
import main.infra.notificacion.factory.NotifierFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class NotifierFactoryTest {

    @Test
    void devNotifierFactoryCreaNotificadoresNoNulos() {

        NotifierFactory factory = new DevNotifierFactory();


        INotifier push = factory.createPushNotifier();
        INotifier email = factory.createEmailNotifier();
        INotifier chat = factory.createChatNotifier();


        assertNotNull(push, "El notificador Push no debería ser nulo");
        assertNotNull(email, "El notificador Email no debería ser nulo");
        assertNotNull(chat, "El notificador Chat no debería ser nulo");
    }

}
