package br.edu.ifsp.prw3.api_2024_2.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(
        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        String cor,

        @Pattern(regexp = "^\\d{4}$", message = "O ano deve estar no formato YYYY (ex: 2010)")
        String ano) {
}



