INSERT INTO users (id, username, password, enabled)
VALUES (1, 'John', '$2a$10$Lijl8XlDUth7C4AgX7IuP.2RhWA58OM570Ht7z3bW9XpSbfVjF6Am', true);


INSERT INTO authorities (id, username, authority)
VALUES (1, 'John', 'read');

INSERT INTO authorities (id, username, authority)
VALUES (2, 'John', 'write');