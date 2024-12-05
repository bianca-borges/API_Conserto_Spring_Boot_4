package br.edu.ifsp.prw3.api_2024_2.conserto;

import br.edu.ifsp.prw3.api_2024_2.mecanico.DadosCadastroMecanico;
import br.edu.ifsp.prw3.api_2024_2.veiculo.DadosVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", message = "A data deve estar no formato dd/MM/yyyy")
        String entrada,

        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", message = "A data deve estar no formato dd/MM/yyyy")
        String saida,

        @NotNull
        @Valid
        DadosVeiculo veiculo,

        @NotNull
        @Valid
        DadosCadastroMecanico mecanico) {
}
