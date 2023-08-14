INSERT INTO category (id, name)
VALUES (gen_random_uuid(), 'Life Style'),
       (gen_random_uuid(), 'Essential Expenses');

INSERT INTO sub_category (id, name, category_id)
VALUES (gen_random_uuid(), 'App', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Bar', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Beauty', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Credit Card', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Purchase', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Donation', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Family', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Internet', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Investing', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Snack', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Fun', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Loan', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Other', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Gift', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Restaurant', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Withdrawal', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Service', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Travel', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Extra', (select id from category where name = 'Life Style')),
       (gen_random_uuid(), 'Residential account', (select id from category where name = 'Essential Expenses')),
       (gen_random_uuid(), 'Education', (select id from category where name = 'Essential Expenses')),
       (gen_random_uuid(), 'Supermarket', (select id from category where name = 'Essential Expenses')),
       (gen_random_uuid(), 'Housing', (select id from category where name = 'Essential Expenses')),
       (gen_random_uuid(), 'Health', (select id from category where name = 'Essential Expenses')),
       (gen_random_uuid(), 'Transport', (select id from category where name = 'Essential Expenses'));



