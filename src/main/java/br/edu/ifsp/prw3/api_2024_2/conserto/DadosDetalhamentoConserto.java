package br.edu.ifsp.prw3.api_2024_2.conserto;

public record DadosDetalhamentoConserto (Long id, String dataEntrada, String dataSaida,
                                        String nomeMecanico, String marcaVeiculo,
                                        String modeloVeiculo){

    public DadosDetalhamentoConserto(Conserto conserto){
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
