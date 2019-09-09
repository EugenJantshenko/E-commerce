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

create table ware
(
    id            bigint not null auto_increment,
    sold          boolean default false,
    manufacturer  varchar(255),
    price         double precision,
    received_date datetime,
    sealed_date   datetime,
    serial_number varchar(255) unique ,
    ware_name     varchar(255),
    type_id       bigint references ware_type (id),
    primary key (id)
);
