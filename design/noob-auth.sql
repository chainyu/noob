SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS T_AU_USER;




/* Create Tables */

CREATE TABLE T_AU_USER
(
	id bigint NOT NULL AUTO_INCREMENT,
	user_name varchar(255) NOT NULL,
	password varchar(500) NOT NULL,
	status tinyint NOT NULL,
	create_time datetime NOT NULL,
	update_time timestamp,
	real_name varchar(255),
	first_name varchar(255),
	last_name varchar(255),
	email varchar(255),
	mobile varchar(20),
	phone varchar(50),
	description varchar(1000),
	avatar varchar(500),
	last_password varchar(500),
	pwd_change_time datetime,
	PRIMARY KEY (id)
);



