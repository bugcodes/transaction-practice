create table transaction_user
(
	id int not null auto_increment
		primary key,
	name varchar(32) null,
	account int null,
	balance decimal(20,3) null,
	update_time timestamp default CURRENT_TIMESTAMP not null,
	create_time timestamp default '0000-00-00 00:00:00' not null,
	status tinyint(1) default '-1' null
);