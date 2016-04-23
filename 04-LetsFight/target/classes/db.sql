CREATE TABLE HP_PEOPLE (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    PRIMARY KEY (id)
);

CREATE TABLE FIGHT (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    HP_PEOPLE_ID INT UNSIGNED not null,
    SWAPI_UID varchar(255) not null,
    WINNER boolean not null,
    PRIMARY KEY (id)
);

insert into HP_PEOPLE (first_name, last_name) values ('Harry', 'Potter');
insert into HP_PEOPLE (first_name, last_name) values ('Hermione', 'Granger');
insert into HP_PEOPLE (first_name, last_name) values ('Severus', 'Rogue');
insert into HP_PEOPLE (first_name, last_name) values ('Voldemort', 'Voldemort');
insert into HP_PEOPLE (first_name, last_name) values ('Ron','Weasley');
insert into HP_PEOPLE (first_name, last_name) values ('Drago','Malefoy');
insert into HP_PEOPLE (first_name, last_name) values ('Albus', 'Dumbledore');