CREATE TABLE public.user (
user_id serial PRIMARY KEY,
cpf varchar(14),
rg varchar(12),
cnpj varchar(18),
email varchar(100),
name varchar(100),
fantasy_name varchar(100),
user_type integer,
land_phone varchar(15),
cell_phone varchar(15),
address varchar(100),
address_number varchar(10),
complement varchar(100),
zip_code varchar(8),
password varchar(100)
);

CREATE TABLE public.agency (
agency_id serial PRIMARY KEY,
agency_number integer
);

CREATE TABLE public.account (
account_id serial PRIMARY KEY,
user_id integer,
agency_id integer,
number integer,
balance DECIMAL(10,2),
FOREIGN KEY(user_id) REFERENCES public.user (user_id),
FOREIGN KEY(agency_id) REFERENCES public.agency (agency_id)
);

CREATE TABLE public.transaction (
transaction_id serial PRIMARY KEY,
account_id integer,
transaction_account integer,
date DATE,
ammount DECIMAL(10,2),
type VARCHAR(1),
FOREIGN KEY(account_id) REFERENCES public.account (account_id),
FOREIGN KEY(transaction_account) REFERENCES public.account (account_id)
);

