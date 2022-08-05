package academy.devdojo.cursodevdojo.repository;

import academy.devdojo.cursodevdojo.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
