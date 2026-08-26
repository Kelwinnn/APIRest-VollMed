alter table medicos
alter column ativo type boolean using (case when ativo = 1 then true else false end);