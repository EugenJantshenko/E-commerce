create table ware_category
(
    id            bigint not null auto_increment,
    category_name varchar(255) unique ,
    primary key (id)
);

create table ware_type
(
    id          bigint not null auto_increment,
    blocked     int default 0,
    type_name   varchar(255) unique ,
    category_id bigint references ware_category (id),
    primary key (id)
);

create table manufacturer
(
    id            bigint not null auto_increment,
    manufacturer_name varchar(255) unique ,
    primary key (id)
);

create table ware_name
(
    id            bigint not null auto_increment,
    ware_name varchar(255) unique ,
    primary key (id)
);

create table ware
(
    id            bigint not null auto_increment,
    sold          boolean default false,
    manufacturer_id  bigint references manufacturer(id),
    price         double precision,
    received_date datetime,
    sealed_date   datetime,
    serial_number varchar(255) unique ,
    ware_name_id     bigint references  ware_name(id) ,
    type_id       bigint references ware_type (id),
    primary key (id)
);
