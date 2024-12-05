package br.edu.ifsp.prw3.api_2024_2.conserto;

import br.edu.ifsp.prw3.api_2024_2.mecanico.Mecanico;
import br.edu.ifsp.prw3.api_2024_2.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entrada;
    private String saida;

    @Embedded
    private Veiculo veiculo;

    @Embedded
    private Mecanico mecanico;
    private Boolean ativo;

    public Conserto(DadosConserto dados) {
        this.ativo = true;
        this.entrada = dados.entrada();
        this.saida = dados.saida();
        this.veiculo = new Veiculo(dados.veiculo());
        this.mecanico = new Mecanico(dados.mecanico().nome(), dados.mecanico().experiencia());
    }

    public void atualizarInformacoes(DadosAtualizacaoConserto dados){
        if (dados.saida() != null){
            this.saida = dados.saida();
        }
        if (dados.mecanico() != null){
            this.mecanico.atualizarInformacoes(dados.mecanico());
        }
    }

    public void excluir(){
        this.ativo = false;
    }
}
