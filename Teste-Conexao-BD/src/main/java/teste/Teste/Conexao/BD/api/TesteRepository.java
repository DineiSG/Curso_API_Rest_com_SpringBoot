package teste.Teste.Conexao.BD.api;

import org.springframework.data.repository.CrudRepository;

public interface TesteRepository extends CrudRepository <Teste, Integer>{

    Iterable<Teste> getTesteById(Integer id);


}
