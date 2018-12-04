create table heroes
(
  id          int auto_increment
    primary key,
  name        varchar(45)  not null,
  universe    varchar(10)  not null,
  power       int(3)       not null,
  description varchar(300) null,
  alive       tinyint      null,
  logo        blob         null,
  phone       int          null
)
  collate = utf8_bin;

#SELECT * FROM heroes;
#insert into heroes (id, name, universe, power) values (2, 'Batman', 'DC', 40)
insert into heroesdb.heroes (name, universe, power) values (superman, marvel, 34);