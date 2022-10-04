--Q1 Retorna nome, usuario e senha do usuario
select u.nome, l.usuario, l.senha 
from usuario u, login l


--Q2 --Q2 Retorna nome do autor, titulo do livro e a editora do livro
select a.nome, l.titulo, e.nome
from autor a, livro l, editora e