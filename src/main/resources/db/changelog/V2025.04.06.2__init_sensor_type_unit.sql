-- liquibase formatted sql

-- changeset yarakhovich_i:1
insert into public.sensor_type(sensor_type_id, name)
values (1, 'Pressure');
insert into public.sensor_type(sensor_type_id, name)
values (2, 'Voltage');
insert into public.sensor_type(sensor_type_id, name)
values (3, 'Temperature');
insert into public.sensor_type(sensor_type_id, name)
values (4, 'Humidity');

insert into public.sensor_unit(sensor_unit_id, name)
values (1, 'bar');
insert into public.sensor_unit(sensor_unit_id, name)
values (2, 'voltage');
insert into public.sensor_unit(sensor_unit_id, name)
values (3, '°С');
insert into public.sensor_unit(sensor_unit_id, name)
values (4, '%');