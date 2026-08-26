alter table pacientes add ativo boolean;

update pacientes set ativo = true where ativo is null;

alter table pacientes alter column ativo set not null;