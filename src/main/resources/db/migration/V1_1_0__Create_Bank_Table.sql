create table if not exists bank
(
    id   uuid not null
    primary key,
    name varchar(255)
    );

alter table bank
    owner to financial;
