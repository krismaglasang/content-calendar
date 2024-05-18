create table if not exists content (
    id serial primary key,
    title varchar(250) not null,
    description text,
    status varchar(20) not null,
    content_type varchar(50) not null,
    date_created timestamp not null,
    date_updated timestamp,
    url varchar(255)
);