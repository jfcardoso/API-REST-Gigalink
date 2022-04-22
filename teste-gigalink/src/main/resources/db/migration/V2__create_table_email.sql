CREATE TABLE public.email (
	id SERIAL NOT NULL,
	email varchar(100) NOT NULL,
	referencia text NULL,
	fornecedor_id integer not null,
	primary key (id),
	CONSTRAINT fk_fornecedor_email FOREIGN KEY(fornecedor_id) REFERENCES fornecedor(id)
);