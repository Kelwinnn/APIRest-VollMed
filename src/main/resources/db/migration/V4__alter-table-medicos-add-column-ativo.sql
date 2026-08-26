alter table medicos add ativo smallint;

update medicos set ativo = '1' where ativo is null;

alter table medicos alter column ativo set not null;