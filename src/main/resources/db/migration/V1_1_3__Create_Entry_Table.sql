create table if not exists entry
(
    entry_date     date not null,
    type           smallint
        constraint entry_type_check
            check ((type >= 0) AND (type <= 1)),
    value          double precision,
    category_id    uuid not null
        constraint fk_category_id
            references category,
    id             uuid not null
        primary key,
    subcategory_id uuid not null
        constraint fk_subcategory_id
            references subcategory,
    description    varchar(255)
);

alter table entry
    owner to financial;
