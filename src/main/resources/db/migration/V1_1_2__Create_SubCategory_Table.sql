create table if not exists staging.subcategory
(
    category_id uuid not null
        constraint fk_category_id
            references staging.category,
    id          uuid not null
        primary key,
    name        varchar(255)
);

alter table staging.subcategory
    owner to financial;
