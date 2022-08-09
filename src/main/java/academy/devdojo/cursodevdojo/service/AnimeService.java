package academy.devdojo.cursodevdojo.service;

import academy.devdojo.cursodevdojo.domain.Anime;
import academy.devdojo.cursodevdojo.requests.AnimePostRequestBody;
import academy.devdojo.cursodevdojo.repository.AnimeRepository;
import academy.devdojo.cursodevdojo.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;
    public List<Anime> listAll(){
        return animeRepository.findAll();
    }
    public Anime findByIdOrThrowBadRequestsException(long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build());
    }
    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestsException(id));
    }
    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestsException(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .id(savedAnime.getId())
                .name(animePutRequestBody.getName())
                .build();

        animeRepository.save(anime);
    }
}
