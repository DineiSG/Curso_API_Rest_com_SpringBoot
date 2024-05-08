package teste.Teste.Conexao.BD.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/teste")
public class TesteController {

    @Autowired
    private TesteService service;

    /*Busca de todos os registros da tabela*/
    @GetMapping
    public Iterable<Teste> get(){
        return service.getTeste();
    }

    /*Busca dos registros por meio do id*/
    @GetMapping("/{id}")
    public Optional<Teste> get(@PathVariable("id") Integer id){
        return service.getTesteById(id);
    }

    /*Salvando dados na tabela*/
    @PostMapping
    public String post(@RequestBody Teste teste){
        Teste novoRegistro=service.insert(teste);
        return "O teste para adicionar um novo registro foi brm sucedido! " + novoRegistro.getId();
    }

    /*Atualizando dados na tabela*/
    @PutMapping(path="/{id}")
    public String put(@PathVariable("id") Integer id, @RequestBody Teste teste){
        Teste updateTeste=service.update(teste, id);
        return "O teste para atualizar um registro existente foi bem sucedido ! " + updateTeste.getId();
    }
    /*Deletando um dado da tabela*/
    @DeleteMapping(path="{id}")
    public String delete(@PathVariable("id") Integer id){
        service.delete(id);
        return "Teste de exclusao de item da tabela realizado com sucesso";
    }


}
