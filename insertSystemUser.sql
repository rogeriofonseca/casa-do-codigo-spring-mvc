-- Hash para password '1234'
insert into Role values('ROLE_ADMIN');
insert into Role values('ROLE_COMPRADOR');
insert into usuario(login,name,password)
values('comprador@gmail.com',
  'Alberto',
  '$2a$10$7nzUTSpi0dsDg7wVy1n2h.80RLeN7aLl3TzyN2.zEORQ/CLNMFLHG');
insert into usuario(login,name,password)
values('admin@casadocodigo.com.br'
  ,'Administrador',
  '$2a$10$7nzUTSpi0dsDg7wVy1n2h.80RLeN7aLl3TzyN2.zEORQ/CLNMFLHG');
insert into usuario_Role(usuario_login,roles_name)
values('comprador@gmail.com','ROLE_COMPRADOR');
insert into usuario_Role(usuario_login,roles_name)
values('admin@casadocodigo.com.br','ROLE_ADMIN');
