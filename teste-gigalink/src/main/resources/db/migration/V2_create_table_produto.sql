CREATE TABLE public.produto (
	id SERIAL NOT NULL,
	nome varchar(100) NOT NULL,
	descricao text not null,
	primary key (id)
);