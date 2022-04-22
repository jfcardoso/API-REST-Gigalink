CREATE TABLE public.item (
	id SERIAL NOT NULL,
	quantidade integer NOT NULL,
	valor decimal(10, 2) not null,
	pedido_id integer not null,
	produto_id integer not null,
	primary key (id),
	CONSTRAINT fk_pedido FOREIGN KEY(pedido_id) REFERENCES pedido(id),
	CONSTRAINT fk_produto FOREIGN KEY(produto_id) REFERENCES produto(id)
);