DROP TABLE IF EXISTS "autor" CASCADE;
DROP TABLE IF EXISTS "editora" CASCADE;
DROP TABLE IF EXISTS "categoria" CASCADE;
DROP TABLE IF EXISTS "usuario" CASCADE;
DROP TABLE IF EXISTS "livro" CASCADE;
DROP TABLE IF EXISTS "exemplar" CASCADE;
DROP TABLE IF EXISTS "login" CASCADE;
DROP TABLE IF EXISTS "cliente" CASCADE;
DROP TABLE IF EXISTS "sebo" CASCADE;
DROP TABLE IF EXISTS "carrinho" CASCADE;
DROP TABLE IF EXISTS "venda" CASCADE;
DROP TABLE IF EXISTS "telefoneusuario" CASCADE;
DROP TABLE IF EXISTS "autorlivro" CASCADE;
DROP TABLE IF EXISTS "autorcategoria" CASCADE;
DROP TABLE IF EXISTS "categoriausuario" CASCADE;
DROP TABLE IF EXISTS "categorialivro" CASCADE;
DROP TABLE IF EXISTS "clientevenda" CASCADE;
DROP TABLE IF EXISTS "sebovenda" CASCADE;
DROP TABLE IF EXISTS "vendaexemplar" CASCADE;


CREATE TABLE autor(
    cod int,
    nome varchar(50) NOT NULL,
    nacionalidade varchar(25) NOT NULL,
    CONSTRAINT autor_pk PRIMARY KEY(cod)
);

CREATE TABLE editora(
    cod int,
    nome varchar(50) NOT NULL,
    cnpj varchar(25) NOT NULL,
    CONSTRAINT editora_pk PRIMARY KEY(cod)

);

CREATE TABLE categoria(
    cod int,
    nome varchar(50) NOT NULL,
    CONSTRAINT categoria_pk PRIMARY KEY(cod)
);

CREATE TABLE usuario(
    cod int,
    nome varchar(100) NOT NULL,
    nacionalidade varchar(25)  NOT NULL,
    email varchar(100) NOT NULL,
    profissao varchar(50) NOT NULL,
    anonascimento date NOT NULL,
    estado varchar(30) NOT NULL,
    cidade varchar(35) NOT NULL,
    bairro varchar(35) NOT NULL,
    rua varchar(40) NOT NULL,
    numero int NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY(cod)
);

CREATE TABLE livro(
    isbn varchar(14),
    codeditora int,
    titulo varchar(50) NOT NULL,
    anopublicacao date NOT NULL,
    CONSTRAINT livro_pk PRIMARY KEY(isbn),
    CONSTRAINT livro_fk FOREIGN KEY(codeditora) REFERENCES editora(cod)
);

CREATE TABLE exemplar(
    cod int,
    quantidade int,
    isbn varchar(14),
    CONSTRAINT exemplar_pk PRIMARY KEY(cod),
    CONSTRAINT exemplar_fk FOREIGN KEY (isbn) REFERENCES livro(isbn)
);

CREATE TABLE login(
    cod int,
    codusuario int,
    senha varchar(15) NOT NULL,
    usuario varchar(15) NOT NULL,
    CONSTRAINT login_pk PRIMARY KEY(cod),
    CONSTRAINT login_fk FOREIGN KEY(codusuario) REFERENCES usuario(cod)
);

CREATE TABLE cliente(
    cpf varchar(20),
    codusuario int,
    CONSTRAINT cliente_pk PRIMARY KEY(cpf, codusuario),
    
    CONSTRAINT cliente_fk FOREIGN KEY(codusuario) REFERENCES usuario(cod)
);

CREATE TABLE sebo(
    cnpj varchar(20),
    nomefantasia varchar(150),
    codusuario int,
    CONSTRAINT sebo_pk PRIMARY KEY(nomefantasia, codusuario),
    CONSTRAINT sebo_fk FOREIGN KEY(codusuario) REFERENCES usuario(cod)
);

CREATE TABLE carrinho(
    cod int,
    item int,
    preco numeric,
    codusuario int,
    CONSTRAINT carrinho_pk PRIMARY KEY(cod, codusuario),
    CONSTRAINT carrinho_fk FOREIGN KEY(codusuario) REFERENCES usuario(cod)
);

CREATE TABLE venda(
    cod int,
    CONSTRAINT venda_pk PRIMARY KEY(cod)
);

CREATE TABLE telefoneusuario(
    codusuario int,
    telefone varchar(15),
    CONSTRAINT telefonevenda_pk PRIMARY KEY(codusuario, telefone),
    CONSTRAINT telefonevenda_fk FOREIGN KEY(codusuario) REFERENCES usuario(cod)
);

CREATE TABLE autorlivro(
    codautor int,
    isbn varchar(14),
    CONSTRAINT autorlivro_pk PRIMARY KEY(codautor, isbn),
    CONSTRAINT autorlivro_fk FOREIGN KEY(codautor) REFERENCES autor(cod) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT isbnlivro_fk FOREIGN KEY(isbn) REFERENCES livro(isbn) ON UPDATE CASCADE ON DELETE CASCADE 
);

CREATE TABLE autorcategoria(
    codautor int,
    codcategoria int,
    CONSTRAINT autorcategoria_pk PRIMARY KEY(codautor, codcategoria),
    CONSTRAINT autorcategoria_fk FOREIGN KEY(codautor) REFERENCES autor(cod) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT categoriaautor_fk FOREIGN KEY(codcategoria) REFERENCES categoria(cod) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE categoriausuario(
    codcategoria int,
    codusuario int,
    CONSTRAINT categoriausuario_pk PRIMARY KEY(codcategoria, codusuario),
    CONSTRAINT categoriausuario_fk FOREIGN KEY(codcategoria) REFERENCES categoria(cod) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT usuariocategoria_fk FOREIGN KEY(codusuario) REFERENCES usuario(cod) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE categorialivro(
    isbn varchar(14),
    codcategoria int,
    CONSTRAINT categorialivro_pk PRIMARY KEY(isbn, codcategoria),
    CONSTRAINT categorialivro_fk FOREIGN KEY(isbn) REFERENCES livro(isbn) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT livrocategoria_fk FOREIGN KEY(codcategoria) REFERENCES categoria(cod) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE clientevenda(
    codusuario int,
    codvenda int,
    CONSTRAINT clientevenda_pk PRIMARY KEY(codusuario, codvenda),
    CONSTRAINT clientevenda_fk FOREIGN KEY(codusuario) REFERENCES usuario(cod) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT vendacliente_fk FOREIGN KEY(codvenda) REFERENCES venda(cod) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE sebovenda(
    codusuario int,
    codvenda int,
    datavenda date NOT NULL,
    CONSTRAINT sebovenda_pk PRIMARY KEY(codusuario, codvenda),
    CONSTRAINT sebovenda_fk FOREIGN KEY(codusuario) REFERENCES usuario(cod) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE vendaexemplar(
    codvenda int,
    codexemplar int,
    CONSTRAINT vendaexemplar_pk PRIMARY KEY(codvenda, codexemplar),
    CONSTRAINT vendaexemplar_fk FOREIGN KEY(codvenda) REFERENCES venda(cod) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT exempplarvenda_fk FOREIGN KEY(codexemplar) REFERENCES exemplar(cod) ON UPDATE CASCADE ON DELETE CASCADE
);



ALTER TABLE sebo ADD COLUMN razaosocial varchar(150) NOT NULL;

ALTER TABLE exemplar ADD COLUMN estado varchar(50) NOT NULL DEFAULT 'NOVO';
