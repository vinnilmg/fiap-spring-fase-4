DROP TABLE IF EXISTS person;

CREATE TABLE person
(
    id                  serial,
    name                varchar(240),
    street_name         varchar(240),
    number              varchar(240),
    city                varchar(240),
    country             varchar(240),
    email               varchar(240),
    phone_number        varchar(240),
    create_date_time    timestamp
);