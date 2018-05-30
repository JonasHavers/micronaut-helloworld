package helloworld

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class HelloControllerSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer =
            ApplicationContext.run(EmbeddedServer)

    @Shared
    HelloControllerClient client = embeddedServer
            .applicationContext
            .getBean(HelloControllerClient)

    @Unroll
    void "test hello #name response"() {
        expect:
        client.hello(name).blockingGet() == 'Hello Jonas!'
        where:
        name = 'Jonas'
    }
}
