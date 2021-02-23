package repository.Anexo.Endereco;

import model.Endereco;

import java.util.List;
import java.util.Map;

public class EnderecoRepository extends  JpaRepository<Endereco, Long>{
    static final String FIND_END = "SELECT ende.tb_endereco_rua as Rua, ende.tb_endereco_cidade as Cidade FROM tb_endereco ende where ende.TB_CLIENTE_ID = ?1";

    @Query(value = FIND_END, nativeQuery = true)
    List<Map<String, String>> findByTbClienteId(String tbClienteId);


}
