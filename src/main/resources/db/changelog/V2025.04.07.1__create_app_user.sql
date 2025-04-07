-- liquibase formatted sql

-- changeset yarakhovich_i:1
create table app_user
(
    app_user_id bigint              not null,
    login       varchar(255) unique not null,
    password    varchar(255),
    primary key (app_user_id)
);
create table app_user_authority
(
    app_user_id  bigint not null,
    authority_id bigint not null,
    unique (app_user_id, authority_id)
);
create table authority
(
    authority_id bigint              not null,
    name         varchar(255) unique not null,
    primary key (authority_id)
);
alter table if exists app_user_authority add constraint fk_authority_id_app_user foreign key (authority_id) references authority;
alter table if exists app_user_authority add constraint fk_app_user_id_authority foreign key (app_user_id) references app_user;