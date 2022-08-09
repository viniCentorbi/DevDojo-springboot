package academy.devdojo.cursodevdojo.mapper;

import academy.devdojo.cursodevdojo.domain.Anime;
import academy.devdojo.cursodevdojo.requests.AnimePostRequestBody;
import academy.devdojo.cursodevdojo.requests.AnimePutRequestBody;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);
}
