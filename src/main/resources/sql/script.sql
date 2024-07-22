create table address
(
    id       uuid         not null
        primary key,
    street   varchar(255) not null,
    city     varchar(255) not null,
    state    varchar(255) not null,
    zip_code varchar(10)  not null,
    country  varchar(255) not null
);

alter table address
    owner to "library-user";

create table library
(
    id         uuid         not null
        primary key,
    name       varchar(255) not null,
    address_id uuid         not null,
    foreign key (address_id) references address (id)
);

alter table library
    owner to "library-user";

create table author
(
    id          uuid         not null
        primary key,
    name        varchar(255) not null,
    description text
);

alter table author
    owner to "library-user";

create table person
(
    id         uuid         not null
        primary key,
    name       varchar(255) not null,
    address_id uuid         not null,
    email      varchar(255) not null,
    phone      varchar(20)  not null,
    foreign key (address_id) references address (id)
);

alter table person
    owner to "library-user";

create table book
(
    id              uuid         not null
        primary key,
    title           varchar(255) not null,
    isbn            varchar(20)  not null,
    subject         varchar(255) not null,
    publisher       varchar(255) not null,
    language        varchar(100) not null,
    number_of_pages integer      not null,
    author_id       uuid         not null,
    foreign key (author_id) references author (id)
);

alter table book
    owner to "library-user";

create table book_item
(
    id               uuid           not null
        primary key,
    book_id          uuid           not null,
    barcode          varchar(255)   not null,
    reference_only   boolean        not null,
    borrowed         date,
    due_date         date,
    price            numeric(10, 2) not null,
    format           varchar(50)    not null,
    status           varchar(50)    not null,
    date_of_purchase date,
    publication_date date,
    library_id       uuid           not null,
    foreign key (book_id) references book (id),
    foreign key (library_id) references library (id)
);

alter table book_item
    owner to "library-user";

create table account
(
    id        uuid         not null
        primary key,
    password  varchar(255) not null,
    status    varchar(50)  not null,
    person_id uuid         not null,
    foreign key (person_id) references person (id)
);

alter table account
    owner to "library-user";

create table book_lending
(
    id            uuid not null
        primary key,
    creation_date date not null,
    due_date      date not null,
    return_date   date,
    book_item_id  uuid not null,
    foreign key (book_item_id) references book_item (id)
);

alter table book_lending
    owner to "library-user";

create table rack
(
    id                  uuid         not null
        primary key,
    number              integer      not null,
    location_identifier varchar(255) not null
);

alter table rack
    owner to "library-user";

create table rack_book_item
(
    rack_id      uuid not null,
    book_item_id uuid not null,
    foreign key (rack_id) references rack (id),
    foreign key (book_item_id) references book_item (id)
);

alter table rack_book_item
    owner to "library-user";

create table book_reservation
(
    id            uuid        not null
        primary key,
    creation_date date        not null,
    status        varchar(50) not null,
    account_id    uuid        not null,
    book_item_id  uuid        not null,
    foreign key (account_id) references account (id),
    foreign key (book_item_id) references book_item (id)
);

alter table book_reservation
    owner to "library-user";

create table library_card
(
    id          uuid         not null
        primary key,
    card_number varchar(255) not null,
    barcode     varchar(255) not null,
    issue_at    date         not null,
    active      boolean      not null,
    account_id  uuid         not null,
    foreign key (account_id) references account (id)
);

alter table library_card
    owner to "library-user";

create table fine
(
    id              uuid           not null
        primary key,
    amount          numeric(10, 2) not null,
    book_lending_id uuid           not null,
    account_id      uuid           not null,
    foreign key (book_lending_id) references book_lending (id),
    foreign key (account_id) references account (id)
);

alter table fine
    owner to "library-user";
