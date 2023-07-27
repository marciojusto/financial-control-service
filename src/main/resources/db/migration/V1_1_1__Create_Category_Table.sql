create table if not exists staging.category
(
    id   uuid not null
        primary key,
    name varchar(255)
);

alter table staging.category
    owner to financial;
