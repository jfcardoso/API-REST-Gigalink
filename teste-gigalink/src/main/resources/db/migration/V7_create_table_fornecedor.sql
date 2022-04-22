CREATE TABLE public.fornecedor (
	id SERIAL NOT NULL,
	nome varchar(200) NOT NULL,
	descricao text NULL,
	cidade varchar(100) not null,
	endereco varchar(200) not null,
	bairro varchar(100) not null,
	numero integer not null
	primary key (id)
);