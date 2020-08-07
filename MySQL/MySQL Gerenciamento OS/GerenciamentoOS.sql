create database Banco_os;

use Banco_os;

create table servico (

	id int not null auto_increment,
    cliente varchar(50),
    descricao varchar(50),
    data date,
    valor float,
    situacao varchar(40),
    
    primary key (id)
    
    );