package br.edu.ifsp.prw3.api_2024_2.mecanico;


import br.edu.ifsp.prw3.api_2024_2.conserto.DadosAtualizacaoConserto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    private String nome;
    private Integer experiencia;


    public Mecanico(DadosCadastroMecanico dados) {
        this.nome = dados.nome();
        this.experiencia = dados.experiencia();
    }

    public void atualizarInformacoes(DadosCadastroMecanico dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.experiencia() != null){
            this.experiencia = dados.experiencia();
        }
    }

}
