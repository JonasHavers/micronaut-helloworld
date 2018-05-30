package helloworld;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.Client;
import io.reactivex.Single;

import javax.validation.constraints.NotBlank;

@Client("/")
public interface HelloControllerClient {

    @Get("/hello/{name}")
    Single<String> hello(@NotBlank String name);
}
