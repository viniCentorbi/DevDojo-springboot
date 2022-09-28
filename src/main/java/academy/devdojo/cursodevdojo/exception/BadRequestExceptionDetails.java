//classe com os detalhes das Exceptions de Bad Request
package academy.devdojo.cursodevdojo.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class BadRequestExceptionDetails extends ExceptionDetails{

}
