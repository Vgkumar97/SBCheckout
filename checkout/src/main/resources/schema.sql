create table product
(
   id integer not null,
   type varchar(50) not null,
   name varchar(50) not null,
   description varchar(255) not null,
   primary key(id)
);

create table cart
(
   name varchar(50) not null,
   quantity integer not null,
   primary key(name)
);
