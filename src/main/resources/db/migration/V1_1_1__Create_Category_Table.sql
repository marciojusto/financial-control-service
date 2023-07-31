create table if not exists category
(
    id   uuid not null
        primary key,
    name varchar(255)
);

alter table category
    owner to financial;
