package de.loopingrobin.fotoapi.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * Die Config-Klasse erstellt alle, auf Interfaces basierenden, Objekte.
 */
@Configuration
public class FotoApiConfig {

    /**
     * Ruft zu direkt nach Programmstart das Repository auf und schreibt alle
     * gefundenen Foto-Infos in die Konsole.
     * @param client der Client für das HTTP-Request
     * @return die Konsolenausgabe der gefundenen Foto-Infos
     */
    @Bean
    public CommandLineRunner commandLineRunner(FotoInfosRepository client){
        return args -> client.findAll().stream().forEach(System.out::println);
    }

    /**
     * Erstellt das Repository und einen Client für einen HTTP-Request.
     * @return den Client für das HTTP-Request mit dem Repository als Service-Typ
     */
    @Bean
    public FotoInfosRepository fotoInfosRepository() {
        WebClient client = WebClient.builder()
                .baseUrl("https://soerensen-foto-api.azurewebsites.net")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client))
                .build();
        return factory.createClient(FotoInfosRepository.class);
    }
}
