INSERT INTO autor( cod, nome, nacionalidade) VALUES (1, 'Machado de Assis', 'Brasil'),
                                                    (2, 'José Saramago', 'Lisboa'),
                                                    (3, 'William Shakespeare', 'Londres'),
                                                    (4, 'Fiódor Dostoiévski', 'Rúsia'),
                                                    (5, 'Jorge Luís Borges', 'Argentina'),
                                                    (6, 'Franz Kafka', 'Praga'),
                                                    (7, 'Gabriel García Márquez', 'Colombia'),
                                                    (8, 'Federico García Lorca', 'Espanha'),
                                                    (9, 'Charles Bukowski', 'Alemanha'),
                                                    (10, 'Antoine de Saint-Exupéry', 'Fraça');

INSERT INTO editora(cod, cnpj, nome) VALUES (1, '123456/999-00','Editora Brasilera'),
                                            (2, '123456/999-01','Editora Livros de Papel'),
                                            (3, '123456/999-02','Editora Livros e Cia'),
                                            (4, '123456/999-03','Editora PredSim'),
                                            (5, '123456/999-04','Editora Livros Samsung'),
                                            (6, '123456/999-05','Editora Books Wold'),
                                            (7, '123456/999-06','Editora Livros e Livros'),
                                            (8, '123456/999-08','Editora Bons livros'),
                                            (9, '123456/999-09','Editota Atitude'),
                                            (10,'123456/999-10','Editora Volumes');

INSERT INTO livro (isbn, codeditora, titulo, anopublicacao) VALUES (9781716221330, 1, 'Dom Casmurro', '01/01/1899'),
                                                                   (9780099532163, 2, 'Ensaio sobre a Cegueira','01/01/1995'),
                                                                   (9788525406118, 3, 'Hamlet','01/01/1603'),
                                                                   (9788573266467, 4, 'Crime e Castigo','01/01/1886'),
                                                                   (9788535911237, 5, 'Ficções','01/01/1944'),
                                                                   (9786580210008, 6, 'A metamorfose','01/01/1915'),
                                                                   (9788501012074, 7, 'Cem anos de solidão','01/01/1967'),
                                                                   (9788503013727, 8, 'O sol é para todos','11/07/1960'),
                                                                   (9788525414656, 9, 'Misto quente','01/09/1982'),
                                                                   (9788595081512, 10, 'O pequeno príncipe','06/04/1943');

INSERT INTO exemplar (cod, quantidade, isbn) VALUES (1, 10, 9781716221330),
                                                    (2, 100, 9780099532163),
                                                    (3, 588, 9788525406118),
                                                    (4, 7000, 9788573266467),
                                                    (5, 50, 9788535911237),
                                                    (6,880, 9786580210008),
                                                    (7,1000, 9788501012074),
                                                    (8,10000, 9788503013727),
                                                    (9,99, 9788525414656),
                                                    (10,220, 9788595081512);

INSERT INTO categoria (cod, nome) VALUES (1, 'Romance'),
                                          (2, 'Terror'),
                                          (3, 'Literatura Rusa'),
                                          (4, 'Ficção Literaria'),
                                          (5, 'Realismo'),
                                          (6, 'Literatura inglessa/Romance'),
                                          (7, 'Conto Literario'),
                                          (8, 'Auto biografia'),
                                          (9, 'Biografia'),
                                          (10, 'Ficção Romantica');

INSERT INTO usuario (cod, nome, nacionalidade, email, profissao, anonascimento, estado, cidade, bairro, rua, numero) VALUES (1, 'kessio Romero','Brasileiro','kessio@email.com','Analista de sitema','17/07/1990','PE','Garanhuns','Centro','Rua Nº1',98),
                                                                                                                            (2, 'Andre Mario','Brasileiro','andre@email.com','Analista de sitema','17/07/1990','PE','Garanhuns','Centro','Rua Nº2',60),
                                                                                                                            (3, 'Mario Ricardo','Brasileiro','mario@email.com','Analista de sitema','17/07/1990','PE','Garanhuns','Centro','Rua Nº3',22),
                                                                                                                            (4, 'Ana Julia','Brasileira','ana@email.com','Analista de sitema','17/07/1990','PE','Garanhuns','Centro','Rua 4',88),
                                                                                                                            (5, 'Rafaela Barros','Brasileira','rafaela@email.com','Analista de sitema','17/07/1990','PE','Garanhuns','Centro','Rua Nº5',123),
                                                                                                                            (6, 'Amanda Aumeida','Brasileira','amanda@email.com','Analista de sitema','17/07/1990','PE','Garanhuns','Centro','Rua Nº6',1022),
                                                                                                                            (7, 'Joaquina da Silva','Brasileira','joaquina@email.com','Analista de sitema','17/07/1990','PE','Garanhuns','Centro','Rua Nº7',588),
                                                                                                                            (8, 'Vera Lucia','Brasileira','vera@email.com','Analista de sitema','17/07/1990','PE','Garanhuns','Centro','Rua Nº8',11),
                                                                                                                            (9, 'Lucelena da Silva','Brasileira','lucelena@email.com','Analista de sitema','17/07/1990','PE','Garanhuns','Centro','Rua Nº9',05),
                                                                                                                            (10, 'Victoria da Silva ','Brasileira','victoria@email.com','Analista de sitema','17/07/1990','PE','Garanhuns','Centro','Rua Nº10',77);

INSERT INTO login (cod, codusuario, senha, usuario) VALUES (1, 1, '123@123', 'kessio'),
                                                           (2, 2, '1233215', 'andre'),
                                                           (3, 3, '7894561', 'mario'),
                                                           (4, 4, 'admin@admin', 'ana'),
                                                           (5, 5, 'admin123', 'rafaela'),
                                                           (6, 6, 'amanda@123', 'amanda'),
                                                           (7, 7, '123456789@', 'joaquina'),
                                                           (8, 8, '@vera123', 'vera'),
                                                           (9, 9, '123@admin', 'lucelena'),
                                                           (10, 10, '@admin@admim', 'victoria');

INSERT INTO cliente (cpf, codusuario) VALUES ('999/888/777-00', 1),
                                              ('111/888/666-11', 2),
                                              ('888/111/555-22', 3),
                                              ('111/222/888-33', 4),
                                              ('999/000/777-44', 5),
                                              ('999/123/777-55', 6),
                                              ('951/789/321-66', 7),
                                              ('357/258/741-77', 8),
                                              ('963/759/351-88', 9),
                                              ('157/953/852-99', 10);

INSERT INTO sebo (cnpj, nomefantasia, codusuario, razaosocial) VALUES ('40.830.994/0001-98', 'Sebo Livros E Fantasia', 1, 'Razao Social Loja 1'),
                                                                      ('20.123.889/0001-01', 'Livros e Revistas Usados LTDA', 2, 'Razao Social Loja 2'),
                                                         			  ('01.951.147/0001-88', 'Livraria Cultura e Cia', 3, 'Razao Social Loja 3'),
                                                         			  ('77.789.520/0001-11', 'Sebo Cantinho da Leitura', 4, 'Razao Social Loja 4'),
                                                         			  ('12.759.351/0001-82', 'Livraria e Cafeteria Cultura Nordestina', 5, 'Razao Social Loja 5'),
                                                         			  ('41.222.555/0001-55', 'Livraria Old Books', 6, 'Razao Social Loja 6'),
                                                         			  ('25.457.865/0001-98', 'Sebo Lugar de Cultura', 7, 'Razao Social Loja 7'),
                                                         			  ('05.745.859/0001-51', 'Livraria Desejos', 8, 'Razao Social Loja 8'),
                                                         			  ('77.985.215/0001-88', 'Sebo 1000 livros', 9, 'Razao Social Loja 9'),
                                                         			  ('00.800.478/0001-41', 'Sebom Bons Livros', 10, 'Razao Social Loja 10');

INSERT INTO carrinho (cod, item, preco, codusuario) VALUES (1, 1, 45.50, 1),
                                                           (2, 2, 145.00, 2),
                                                           (3, 3, 200.00, 3),
                                                           (4, 4, 75.00, 4),
                                                           (5, 5, 55.78, 5),
                                                           (6, 6, 132.00, 6),
                                                           (7, 7, 100.00, 7),
                                                           (8, 8, 101.00, 8),
                                                           (9, 9, 88.00, 9),
                                                           (10, 10, 157.00, 10);

INSERT INTO venda (cod) VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10);

INSERT INTO telefoneusuario (codusuario, telefone) VALUES (1, '(87) 9960-5555'),
                                                          (2, '(87) 9960-5000'),
                                                          (3, '(87) 9960-5111'),
                                                          (4, '(87) 9960-5222'),
                                                          (5, '(87) 9960-5333'),
                                                          (6, '(87) 9960-5444'),
                                                          (7, '(87) 9960-5666'),
                                                          (8, '(87) 9960-5777'),
                                                          (9, '(87) 9960-5888'),
                                                          (10, '(87) 9960-5999');
														  
														 