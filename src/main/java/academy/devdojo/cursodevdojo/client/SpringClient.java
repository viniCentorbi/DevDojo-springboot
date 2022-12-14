package academy.devdojo.cursodevdojo.client;

import academy.devdojo.cursodevdojo.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {

        //Buscar anime
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 2);
        log.info(entity);

        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 2);
        log.info(object);

        //Listar animes
        ResponseEntity<List<Anime>> animes = new RestTemplate().exchange("http://localhost:8080/animes/all",
                                                                        HttpMethod.GET,
                                                                        null,
                                                                        new ParameterizedTypeReference<List<Anime>>() {});
        log.info(animes);

        //Inserir animes
        Anime jujutsuKaisen = Anime.builder().name("Jujutsu Kaisen").build();
        ResponseEntity<Anime> jujutsuKaisenSaved = new RestTemplate().exchange("http://localhost:8080/animes/",
                                                                                HttpMethod.POST,
                                                                                new HttpEntity<>(jujutsuKaisen),
                                                                                Anime.class);
    }
}
