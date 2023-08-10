alter table entry
    drop constraint entry_pkey;

alter table entry
    add constraint entry_pkey
        primary key (entry_date, id, description);
