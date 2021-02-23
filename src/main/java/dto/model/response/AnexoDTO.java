package dto.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.ReprestationModel;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@EqualsAndHashCode(callsuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class AnexoDTO extends RepresentationModel<AnexoDTO> {

    private Long tbArquivoId;

    @NotNull
    @NotBlank(message="Inválido.")
    private String file;

    @NotNull
    private String tbClienteId;
}
