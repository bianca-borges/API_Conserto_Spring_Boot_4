package br.edu.ifsp.prw3.api_2024_2.mecanico;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroMecanico(
        @NotBlank
        String nome,

        Integer experiencia) {
}
