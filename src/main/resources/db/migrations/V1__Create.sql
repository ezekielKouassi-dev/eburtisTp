CREATE TABLE IF NOT EXISTS departement (
    id SERIAL PRIMARY KEY NOT NULL,
    code VARCHAR(255) NOT NULL,
    designation VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS personne (
    id SERIAL PRIMARY KEY NOT NULL,
    nom VARCHAR(255) NOT NULL,
    prenoms VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    id_department INT REFERENCES departement(id)
);
