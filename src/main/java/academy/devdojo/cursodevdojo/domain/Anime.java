package academy.devdojo.cursodevdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //gera getters, setters, equals and hashcodes
@AllArgsConstructor
public class Anime {
    private Long id;
    private String name;
}
