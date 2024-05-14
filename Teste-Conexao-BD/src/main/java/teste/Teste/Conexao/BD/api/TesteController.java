package teste.Teste.Conexao.BD.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/teste")
public class TesteController {

    @Autowired
    private TesteService service;

    /*Busca de todos os registros da tabela*/
    @GetMapping
    public ResponseEntity<Iterable<Teste>> get(){
        return ResponseEntity.ok(service.getTeste());
    }

    /*Busca dos registros por meio do id*/
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Integer id){
        Optional<Teste> teste=service.getTesteById(id);
        return teste
                .map(Veiculos -> ResponseEntity.ok(teste))
                .orElse(ResponseEntity.notFound().build());
        /*Adicionado o retornao de status de acordo com o retorno da busca por id*/

    }

    /*Salvando dados na tabela*/
    @PostMapping
    public ResponseEntity post(@RequestBody Teste teste){
        Teste novoRegistro=service.insert(teste);
        return ResponseEntity.ok("Teste para adicionar item bem sucedido.");
    }

    /*Atualizando dados na tabela*/
    @PutMapping(path="/{id}")
    public ResponseEntity put(@PathVariable("id") Integer id, @RequestBody Teste teste){
        Teste updateTeste=service.update(teste, id);
        return ResponseEntity.ok("Teste para atualizar um item bem sucedido.");
    }


    /*Deletando um dado da tabela*/
    @DeleteMapping(path="{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        boolean ok=service.delete(id);
        return ok?
                ResponseEntity.ok("Teste de exclusao de registro bem sucedido"):
                ResponseEntity.notFound().build();
    }


}
