create table if not exists total_balance
(
    date  date,
    month smallint
        constraint total_balance_month_check
            check ((month >= 0) AND (month <= 11)),
    value double precision,
    id    uuid not null
        primary key
);

alter table total_balance
    owner to financial;
