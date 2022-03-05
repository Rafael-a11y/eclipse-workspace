select database();
create database if not exists frutaria;
use frutaria;
create table if not exists fruta(id int not null auto_increment primary key, descricao varchar(60) not null, quantidade int not null);
alter table fruta auto_increment = 1;