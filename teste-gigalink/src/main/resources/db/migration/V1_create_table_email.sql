CREATE TABLE public.email (
	id SERIAL NOT NULL,
	email varchar(100) NOT NULL,
	referencia text NULL,
	primary key (id)
);