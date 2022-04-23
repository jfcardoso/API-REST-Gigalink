CREATE TABLE public.produto (
	id SERIAL NOT NULL,
	nome varchar(100) NOT NULL,
	descricao text not null,
	fornecedor_id integer not null,
    primary key (id),
    CONSTRAINT fk_fornecedor_produto FOREIGN KEY(fornecedor_id) REFERENCES fornecedor(id)
	);