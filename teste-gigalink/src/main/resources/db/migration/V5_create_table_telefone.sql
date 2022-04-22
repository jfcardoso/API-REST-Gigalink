CREATE TABLE public.telefone (
	id SERIAL NOT NULL,
	ddd varchar(2) NOT NULL,
	numero varchar(9) not null
	referencia text NULL,
	primary key (id)
);