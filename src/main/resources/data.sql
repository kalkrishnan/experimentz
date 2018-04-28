insert into measurement_type
values(1,'Contrast Ratio');
insert into measurement_type
values(2,'Reflectance');
insert into measurement_type
values(3,'Yellowness Index');
insert into measurement_type
values(4,'Tint Strength vs. X-rite');
insert into measurement_type
values(5,'LTC');
insert into measurement_type
values(6,'Gloss UPW');
insert into measurement_type
values(7,'Tint Strength vs X-rite');
insert into measurement_type
values(8,'Rhealogy (KU/ICI) Base');
insert into measurement_type
values(9,'WPG');
insert into measurement_type
values(10,'pH');

insert into condition_type
values(1,'Initial');
insert into condition_type
values(2,'ON');
insert into condition_type
values(3,'3D');
insert into condition_type
values(4,'7D');
insert into condition_type
values(5,'Delta KU');
insert into condition_type
values(6,'FD (Fresh), 3 mil');
insert into condition_type
values(7,'AD (Fresh), 3 mil');
insert into condition_type
values(8,'Rub-up');
insert into condition_type
values(9,'3 mil - FD');
insert into condition_type
values(10,'3 mil - AD, ON');
insert into condition_type
values(11,'3 mil - AD, 7D');
insert into condition_type
values(12,'3 mil - FD');
insert into condition_type
values(13,'FD');
insert into condition_type
values(14,'AD');

insert into user(id, user_name, password)
values(1,'kkrishnan','password');

insert into user(id, user_name, password)
values(2,'jjones','password');


--insert into measurement_type_condition_types
--values(1,13);
--insert into measurement_type_condition_types
--values(2,13);
--insert into measurement_type_condition_types
--values(3,13);
--insert into measurement_type_condition_types
--values(1,14);	
--insert into measurement_type_condition_types
--values(2,14);	
--insert into measurement_type_condition_types
--values(3,14);	