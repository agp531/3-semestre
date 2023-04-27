
create database dblocadora;
use dblocadora;

create table tb_veiculos(codigo int(4) not null auto_increment, marca varchar(30) not null, modelo varchar(40) not null, chassi varchar(30) not null, ano int(4) not null, primary key(codigo));

show tables;
select * from tb_veiculos;


create table tb_clientes(codigo int(4) primary key not null AUTO_INCREMENT, nome varchar(30) not null, cnh int(9) not null, telefone varchar(20) not null, endereco varchar(50) not null);

select * from tb_clientes;