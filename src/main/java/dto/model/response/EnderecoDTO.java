package dto.model.response;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NUll)
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO extends RepresentationModel<EnderecoDTO> {

    @NotNull
    private Long tbEnderecoId;

    @NotNull
    private Long clienteId;

    @NotNull
    @NotBlank(message="CEP INVÁLIDO.")
    @Pattern(regexp  = "\\d{8}-\\d{5}", message = "CEP INVÁLIDO.")
    private String cep;

    @NotNull
    @NotBlank(message="RUA INVÁLIDO.")
    private String rua;

    @NotNull
    @NotBlank(message="BAIRRO INVÁLIDO.")
    private String bairro;

    @NotNull
    @NotBlank(message="COMPLEMENTO INVÁLIDO.")
    private String complemento;

    @NotNull
    @NotBlank(message="CIDADE INVÁLIDO.")
    private String cidade;

    @NotNull
    @NotBlank(message="ESTADO INVÁLIDO.")
    private String estado;

    public Endereco convertDTOToEntity(){ return new ModelMapper().map(this, Endereco.class);}



}
