CREATE TABLE link (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descricao VARCHAR(500),
    url VARCHAR(500) NOT NULL,
    idplaylist INTEGER REFERENCES playlist(id),
    dtcadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dtultalt TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);