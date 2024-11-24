
INSERT INTO autor (nome, nacionalidade) VALUES ('J.K. Rowling', 'Britânica');
INSERT INTO autor (nome, nacionalidade) VALUES ('George R.R. Martin', 'Americano');
INSERT INTO autor (nome, nacionalidade) VALUES ('J.R.R. Tolkien', 'Britânico');
INSERT INTO autor (nome, nacionalidade) VALUES ('Agatha Christie', 'Britânica');
INSERT INTO autor (nome, nacionalidade) VALUES ('Stephen King', 'Americano');
INSERT INTO autor (nome, nacionalidade) VALUES ('Isaac Asimov', 'Americano');
INSERT INTO autor (nome, nacionalidade) VALUES ('F. Scott Fitzgerald', 'Americano');
INSERT INTO autor (nome, nacionalidade) VALUES ('Haruki Murakami', 'Japonês');
INSERT INTO autor (nome, nacionalidade) VALUES ('Gabriel García Márquez', 'Colombiano');
INSERT INTO autor (nome, nacionalidade) VALUES ('Mario Vargas Llosa', 'Peruano');


INSERT INTO genero (descricao) VALUES ('Ficção Científica');
INSERT INTO genero (descricao) VALUES ('Fantasia');
INSERT INTO genero (descricao) VALUES ('Mistério');
INSERT INTO genero (descricao) VALUES ('Romance');
INSERT INTO genero (descricao) VALUES ('Terror');
INSERT INTO genero (descricao) VALUES ('Aventura');
INSERT INTO genero (descricao) VALUES ('Drama');
INSERT INTO genero (descricao) VALUES ('Histórico');
INSERT INTO genero (descricao) VALUES ('Policial');
INSERT INTO genero (descricao) VALUES ('Biografia');

INSERT INTO livro (id_autor, id_genero, titulo, ano_publicacao) 
VALUES (1, 2, 'Harry Potter e a Pedra Filosofal', 1997);

INSERT INTO livro (id_autor, id_genero, titulo, ano_publicacao) 
VALUES (1, 2, 'Harry Potter e a Câmara Secreta', 1998);

INSERT INTO livro (id_autor, id_genero, titulo, ano_publicacao) 
VALUES (2, 1, '1984', 1949);

INSERT INTO livro (id_autor, id_genero, titulo, ano_publicacao) 
VALUES (3, 3, 'Assassinato no Expresso Oriente', 1934);

INSERT INTO livro (id_autor, id_genero, titulo, ano_publicacao) 
VALUES (4, 2, 'O Senhor dos Anéis: A Sociedade do Anel', 1954);

INSERT INTO livro (id_autor, id_genero, titulo, ano_publicacao) 
VALUES (4, 2, 'O Hobbit', 1937);

INSERT INTO livro (id_autor, id_genero, titulo, ano_publicacao) 
VALUES (5, 5, 'It: A Coisa', 1986);

INSERT INTO livro (id_autor, id_genero, titulo, ano_publicacao) 
VALUES (5, 5, 'O Iluminado', 1977);

INSERT INTO livro (id_autor, id_genero, titulo, ano_publicacao) 
VALUES (2, 1, 'A Revolução dos Bichos', 1945);

INSERT INTO livro (id_autor, id_genero, titulo, ano_publicacao) 
VALUES (3, 3, 'Morte no Nilo', 1937);




