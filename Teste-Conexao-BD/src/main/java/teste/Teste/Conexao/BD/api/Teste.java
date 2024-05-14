package teste.Teste.Conexao.BD.api;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="teste")
public class Teste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private String email;

    public Teste(){
    }

    public Teste(Integer id, String nome, String email){
        this.id=id;
        this.nome=nome;
        this.email=email;
    }



}
