package factory;

import model.Cliente;

import com.example.BancoDigital.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("FakeCliente")
public class ClienteFactory implements ClienteDAO {

    private static List<Cliente> DB = new ArrayList<>();

    @Override
    public int save(Cliente cliente) {
        DB.add(new Cliente(cliente.getNome(), cliente.getSobrenome(), cliente.getCpf(), cliente.getEmail(), cliente.getCnh(), cliente.getDtNasc()));
        return 1;
    }

    @Override
    public List<Cliente> findAll() {
        return DB;
    }
}
