CREATE TABLE playlist (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descricao VARCHAR(500),
    dtcadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dtultalt TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
