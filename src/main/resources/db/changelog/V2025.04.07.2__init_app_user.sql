-- liquibase formatted sql

-- changeset yarakhovich_i:1
insert into app_user (app_user_id, login, password)
values (1, 'admin', '$2a$10$28ze2UnARwqZLhBcmfqfSuM6H51ZI8sfFMYPxV4MV0/2ZN2tAN40y');
insert into app_user (app_user_id, login, password)
values (2, 'user', '$2a$10$X9XcqKvKmQwTZg/NQWIr5.V9AgyVIyHKWEj/2e/aa5D4jJbxjXe66');

insert into authority (authority_id, name)
values (1, 'Administrator');
insert into authority (authority_id, name)
values (2, 'Viewer');

insert into app_user_authority (app_user_id, authority_id)
values (1, 1);
insert into app_user_authority (app_user_id, authority_id)
values (1, 2);
insert into app_user_authority (app_user_id, authority_id)
values (2, 2);