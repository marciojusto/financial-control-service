create table if not exists staging.entry
(
    date           date,
    type           smallint
        constraint entry_type_check
            check ((type >= 0) AND (type <= 1)),
    value          double precision,
    category_id    uuid not null
        constraint fk_category_id
            references staging.category,
    id             uuid not null
        primary key,
    subcategory_id uuid not null
        constraint fk_subcategory_id
            references staging.subcategory,
    description    varchar(255)
);

alter table staging.entry
    owner to financial;
