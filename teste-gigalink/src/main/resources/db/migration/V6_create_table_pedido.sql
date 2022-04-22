CREATE TABLE public.pedido (
	id SERIAL NOT NULL,
	data_hora varchar(10) NOT NULL,
	nota_fiscal varchar(80)not null,
	valor_frete real not null,
	desconto real null,
	valor total real not null
	primary key (id)
);