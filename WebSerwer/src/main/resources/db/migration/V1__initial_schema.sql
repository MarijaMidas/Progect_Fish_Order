create table orders
(
    id bigserial not null primary key,
    date_create timestamp,
    completed boolean,
    city integer,
    notice varchar(255)
);

create table clients
(
    id bigserial not null primary key,
    name varchar(50),
    phone varchar(50),
    order_key bigint references orders(id)
);

create table products
(
    id bigserial not null primary key,
    trout varchar(50),
    caviar varchar(50),
    cod_liver varchar(50),
    order_key bigint references orders(id)
);

create table managers
(
    id bigserial not null primary key,
    name varchar(50),
    email varchar(50)
);

-- insert into orders(id,completed,city)
-- values ('51', 'true', '1'),
--        ('52', 'true', '1'),
--        ('53', 'true', '2'),
--        ('54', 'true', '3'),
--        ('55', 'false', '3');
--
-- insert into clients(id,name,phone,order_key)
-- values ('51', 'Ban', '960','51'),
--        ('52', 'Lyly', '870','52'),
--        ('53', 'Jon', '650','53'),
--        ('54', 'Smith', '820','54'),
--        ('55', 'Bob', '450','55');
--
-- insert into products(id,trout,caviar,cod_liver,order_key)
-- values ('51', '5', '1','0','51'),
--        ('52', '4', '0','0','52'),
--        ('53', '1', '0','3','53'),
--        ('54', '1', '0','3','54'),
--        ('55', '1', '0','3','55');