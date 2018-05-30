package helloworld;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/hello")
public class HelloController {

    @Get("/{name}")
    public Single<String> hello(String name) {
        return Single.just("Hello " + name + "!");
    }
}
