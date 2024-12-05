package br.edu.ifsp.prw3.api_2024_2.conserto;

import br.edu.ifsp.prw3.api_2024_2.mecanico.Mecanico;
import br.edu.ifsp.prw3.api_2024_2.veiculo.Veiculo;

public record DadosListagemConserto(Long id, String dataEntrada, String dataSaida,
                                    String nomeMecanico, String marcaVeiculo,
                                    String modeloVeiculo) {

    public DadosListagemConserto(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getEntrada(),
                conserto.getSaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo()
        );
    }
}
