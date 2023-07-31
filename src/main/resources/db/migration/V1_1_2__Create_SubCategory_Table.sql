create table if not exists subcategory
(
    category_id uuid not null
        constraint fk_category_id
            references category,
    id          uuid not null
        primary key,
    name        varchar(255)
);

alter table subcategory
    owner to financial;
