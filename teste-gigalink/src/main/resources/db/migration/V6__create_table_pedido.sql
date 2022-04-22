CREATE TABLE public.pedido (
	id SERIAL NOT NULL,
	data_hora timestamp NOT NULL,
	nota_fiscal varchar(80) not null,
	valor_frete decimal(10, 2) not null,
	desconto decimal(10, 2) null,
	valor_total decimal(10, 2) not null,
	transportadora_id integer null,
	primary key (id),
	CONSTRAINT fk_transportadora FOREIGN KEY(transportadora_id) REFERENCES transportadora(id)
);