package repository.Anexo.Anexo;

import com.example.BancoDigital.model.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AnexoRepository extends JpaRepository<Anexo, Long> {
}
