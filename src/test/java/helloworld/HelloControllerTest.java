package helloworld;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloControllerTest {

    private EmbeddedServer server;
    private HelloControllerClient client;

    @Before
    public void setup() {
        this.server = ApplicationContext.run(EmbeddedServer.class);
        this.client = server.getApplicationContext().getBean(HelloControllerClient.class);
    }

    @Test
    public void shouldReturnHello() {
        String response = client.hello("Jonas").blockingGet();
        assertEquals(response, "Hello Jonas!");
    }

    @After
    public void cleanup() {
        this.server.stop();
    }
}
