create table if not exists staging.bank
(
    id   uuid not null
    primary key,
    name varchar(255)
    );

alter table staging.bank
    owner to financial;
