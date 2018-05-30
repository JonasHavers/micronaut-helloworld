package helloworld;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HelloControllerAlternativeTest {

    private EmbeddedServer server;
    private HttpClient client;

    @Before
    public void setup() {
        this.server = ApplicationContext.run(EmbeddedServer.class);
        this.client = HttpClient.create(this.server.getURL());
    }

    @Test
    public void shouldReturnHello() {
        String response = client.toBlocking()
                .retrieve(HttpRequest.GET("/hello/Jonas"));
        assertEquals(response, "Hello Jonas!");
    }

    @After
    public void cleanup() throws IOException {
        this.server.stop();
        this.client.close();
    }
}
