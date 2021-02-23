package repository.Anexo.Cliente;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import model.Cliente;
import java.util.List;
import java.util.Map;


public class ClienteRepository extends JpaRepository<Cliente, Long> {

    static final String FIND_CLI_BY_CPF = "SELECT CLI.TB_CLIENTE_ID AS ID FROM TB_CLIENTE CLI WHERE CLI.TB_CLIENTE_CPF = ?1";

    @Query(value = FIND_CLI_BY_CPF, nativeQuery = true)
    List<Map<String, String>> findClienteByCpf(String cpf);

    static final String FIND_CLI_BY_EMAIL = "SELECT CLI.TB_CLIENTE_ID AS ID FROM TB_CLIENTE CLI WHERE CLI.TB_CLIENTE_EMAIL = ?1";

    @Query(value = FIND_CLI_BY_EMAIL, nativeQuery = true)
    List<Map<String, String>> findClienteByEmail(String email);
}
