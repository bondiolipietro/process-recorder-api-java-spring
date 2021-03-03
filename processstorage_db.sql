drop database processstoragedb;
drop user processstorage;
create user processstorage with password 'password';
create database processstoragedb with template=template0 owner=processstorage;
\connect processstoragedb;
alter default privileges grant all on tables to processstorage;
alter default privileges grant all on sequences to processstorage;

create table user_account(
user_id integer primary key not null,
first_name varchar(24) not null,
last_name varchar(48) not null,
email varchar(64) not null,
password varchar(64)  not null
);

create table process(
process_id integer primary key not null,
first_name varchar(24) not null,
last_name varchar(48) not null,
cpf varchar(24) not null,
email varchar(64) not null,
folder integer,
receipt varchar(96) not null,
receipt_issue_date date not null,
address varchar(96) not null,
district varchar(24) not null,
city varchar(24) not null,
state varchar(24) not null,
country varchar(24) not null,
cep varchar(24) not null,
notes varchar(4096)
);

create sequence user_seq increment 1 start 1;
create sequence process_seq increment 1 start 1;