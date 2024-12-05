CREATE TABLE consertos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    entrada VARCHAR(255) NOT NULL,
    saida VARCHAR(255),

    -- Atributos do Veiculo
    modelo VARCHAR(255) NOT NULL,
    marca VARCHAR(255) NOT NULL,
    ano INT NOT NULL,

    -- Atributos do Mecanico
    nome VARCHAR(255) NOT NULL,
    experiencia INT NOT NULL
);
