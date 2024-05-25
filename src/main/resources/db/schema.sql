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

-- seed
insert into content (title, description, status, content_type, date_created, date_updated, url)
    values (
        'Learning Data Engineering',
        'Learn data engineering end-to-end',
        'IN_PROGRESS',
        'ARTICLE',
        '2024-05-19 12:34:56',
        null,
        'https://thinkingintensors.co.nz/learning-data-engineering'
    )