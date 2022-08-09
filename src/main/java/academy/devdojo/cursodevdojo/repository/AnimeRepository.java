package academy.devdojo.cursodevdojo.repository;

import academy.devdojo.cursodevdojo.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
