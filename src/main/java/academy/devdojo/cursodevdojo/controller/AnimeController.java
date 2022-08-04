package academy.devdojo.cursodevdojo.controller;

import academy.devdojo.cursodevdojo.domain.Anime;
import academy.devdojo.cursodevdojo.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/anime")
@Log4j2
@AllArgsConstructor
public class AnimeController {
    private DateUtil dateUtil;

    @GetMapping(path = "/list")
    public List<Anime> list(){
        return List.of(new Anime("One Piece"), new Anime("One Punch Man"));
    }
}
