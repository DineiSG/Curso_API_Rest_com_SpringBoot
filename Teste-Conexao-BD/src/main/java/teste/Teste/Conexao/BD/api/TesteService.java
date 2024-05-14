package teste.Teste.Conexao.BD.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TesteService {

    @Autowired
    private TesteRepository rep;


    /*Buscando todos os registros da tabela teste do BD*/
    public Iterable<Teste> getTeste(){
        return rep.findAll();
    }

    /*Buscando os registros da tabela teste do BD pelo ID*/
    public Optional<Teste> getTesteById(Integer id) {
        return rep.findById(id);
    }

    /*Salvando dados na tabela teste*/
    public Teste insert(Teste teste){
        /*Aqui o save nao pode ser alterado para insert por que ele ja esta criado na classe CRUD Repository*/
        return rep.save(teste);
    }

    /*Atualizando um dado na tabela. O "teste" corresponde ao objeto da tabela teste.*/
    public Teste update(Teste teste, Integer id ){
        Optional<Teste> optional = getTesteById(id);

        if(optional.isPresent()){
            Teste reg=optional.get();
            rep.save(teste);

            return teste;
        }else{
            throw new RuntimeException("Não foi possivel alterar o registro na tabela");
        }
    }
    /*Excluindo arquivos da tabela*/
    public boolean delete(Integer id){
        if (getTesteById(id).isPresent()){
            rep.deleteById(id);
            return true;
        }
        return false;

    }
}






