CREATE TABLE users (
    id INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    id INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    authority VARCHAR(255) NOT NULL
);