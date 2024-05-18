create table if not exists run (
    run_id int not null,
    title varchar(250) not null,
    miles int not null,
    primary key (run_id)
);

insert into run (run_id, title, miles) values (1, 'Monday', 3), (2, 'Wednesday', 5), (3, 'Saturday', 8);