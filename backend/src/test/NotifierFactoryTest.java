package test;



import main.infra.notificacion.INotifier;
import main.infra.notificacion.factory.DevNotifierFactory;
import main.infra.notificacion.factory.NotifierFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * --- TEST UNITARIO 1 (Sugerido por la consigna) ---
 * Prueba el Patrón Abstract Factory.
 */
class NotifierFactoryTest {

    @Test
    void devNotifierFactoryCreaNotificadoresNoNulos() {
        // 1. Arrange (Preparar)
        NotifierFactory factory = new DevNotifierFactory();

        // 2. Act (Actuar)
        INotifier push = factory.createPushNotifier();
        INotifier email = factory.createEmailNotifier();
        INotifier chat = factory.createChatNotifier();

        // 3. Assert (Verificar)
        assertNotNull(push, "El notificador Push no debería ser nulo");
        assertNotNull(email, "El notificador Email no debería ser nulo");
        assertNotNull(chat, "El notificador Chat no debería ser nulo");
    }

    // (Se podría hacer un test similar para ProdNotifierFactory)
}
