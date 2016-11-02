SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS T_AU_MENU;
DROP TABLE IF EXISTS T_AU_PRIVILEGE;
DROP TABLE IF EXISTS T_AU_PRIVILEGE_URL;
DROP TABLE IF EXISTS T_AU_ROLE;
DROP TABLE IF EXISTS T_AU_ROLE_PRIVILEGE;
DROP TABLE IF EXISTS T_AU_USER;
DROP TABLE IF EXISTS T_AU_USER_ROLE;




/* Create Tables */

CREATE TABLE T_AU_MENU
(
	id bigint NOT NULL AUTO_INCREMENT,
	label varchar(255) NOT NULL,
	sort_no int NOT NULL,
	url varchar(1000) NOT NULL,
	parent bigint,
	icon varchar(500),
	status tinyint NOT NULL,
	create_time datetime NOT NULL,
	update_time timestamp,
	PRIMARY KEY (id)
);



CREATE TABLE T_AU_PRIVILEGE
(
	id bigint NOT NULL AUTO_INCREMENT,
	code varchar(100) NOT NULL,
	name varchar(255) NOT NULL,
	description varchar(1000),
	group_name varchar(255),
	status tinyint NOT NULL,
	create_time datetime NOT NULL,
	update_time timestamp NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE T_AU_PRIVILEGE_URL
(
	id bigint NOT NULL AUTO_INCREMENT,
	privilege_id bigint,
	url varchar(1000) NOT NULL,
	description varchar(1000),
	status tinyint NOT NULL,
	create_time datetime NOT NULL,
	update_time timestamp,
	PRIMARY KEY (id)
);


CREATE TABLE T_AU_ROLE
(
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	description varchar(1000),
	status tinyint NOT NULL,
	create_time datetime NOT NULL,
	update_time timestamp,
	PRIMARY KEY (id)
);


CREATE TABLE T_AU_ROLE_PRIVILEGE
(
	id bigint NOT NULL AUTO_INCREMENT,
	role_id bigint NOT NULL,
	privilege_id bigint NOT NULL,
	create_time datetime NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE T_AU_USER
(
	id bigint NOT NULL AUTO_INCREMENT,
	user_name varchar(255) NOT NULL,
	password varchar(500) NOT NULL,
	status tinyint NOT NULL,
	create_time datetime NOT NULL,
	update_time timestamp NOT NULL,
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


CREATE TABLE T_AU_USER_ROLE
(
	id bigint NOT NULL AUTO_INCREMENT,
	user_id bigint NOT NULL,
	role_id bigint NOT NULL,
	create_time datetime NOT NULL,
	PRIMARY KEY (id)
);



