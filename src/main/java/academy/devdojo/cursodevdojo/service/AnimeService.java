package academy.devdojo.cursodevdojo.service;

import academy.devdojo.cursodevdojo.domain.Anime;
import academy.devdojo.cursodevdojo.exception.BadRequestException;
import academy.devdojo.cursodevdojo.mapper.AnimeMapper;
import academy.devdojo.cursodevdojo.requests.AnimePostRequestBody;
import academy.devdojo.cursodevdojo.repository.AnimeRepository;
import academy.devdojo.cursodevdojo.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll(){
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestsException(long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not Found"));
    }

    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        //injeção de dependência seria outra alternativa
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestsException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {

        Anime savedAnime = findByIdOrThrowBadRequestsException(animePutRequestBody.getId());

        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());

        animeRepository.save(anime);
    }
}
