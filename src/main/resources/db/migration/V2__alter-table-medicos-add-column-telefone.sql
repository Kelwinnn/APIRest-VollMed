alter table medicos add telefone varchar(20);

update medicos set telefone = 'não informado' where telefone is null;

alter table medicos alter column telefone set not null;