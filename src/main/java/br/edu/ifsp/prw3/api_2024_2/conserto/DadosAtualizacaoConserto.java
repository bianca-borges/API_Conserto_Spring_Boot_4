package br.edu.ifsp.prw3.api_2024_2.conserto;
import br.edu.ifsp.prw3.api_2024_2.mecanico.DadosCadastroMecanico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(
        @NotNull
        Long id,

        String saida,

        DadosCadastroMecanico mecanico
) {


}
