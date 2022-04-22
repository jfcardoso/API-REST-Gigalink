CREATE TABLE public.telefone (
	id SERIAL NOT NULL,
	ddd varchar(2) NOT NULL,
	numero varchar(9) not null,
	referencia text NULL,
	fornecedor_id integer not null,
	primary key (id),
	CONSTRAINT fk_fornecedor_telefone FOREIGN KEY(fornecedor_id) REFERENCES fornecedor(id)
);