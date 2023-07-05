alter table consultas add ativo tinyint;
alter table consultas add motivo varchar(100);
update consultas set ativo =1;
update consultas set motivo = null;