package academy.devdojo.cursodevdojo.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {

    @NotEmpty(message = "The name cannot be empty")
    private String name;
}
