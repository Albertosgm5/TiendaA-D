
insert into Cliente (nombre, apellidos, fechaNacimniento, email, banco, titular, codigoSeguridad, numTarjeta, direccionEnvio, direccionFacturacion, nombreUsuario, password) values ('admin','admin','1992-06-05','admin@gmail.com','admin','admin',111,1000999900001111,'admin','admin','admin', '$2a$10$x81Gc/y2Abgous23qb/6DOAWHm9UlzZl35wRo4emOUAIglRce/Pzu');
insert into Cliente (nombre, apellidos, fechaNacimniento, email, banco, titular, codigoSeguridad, numTarjeta, direccionEnvio, direccionFacturacion, nombreUsuario, password) values ('user','user','1997-08-05','usergmail.com','user','user',222,2200999900001211,'user','user','user', '$2a$10$0prZ1MMAqlXxVtLwv8o0ZOrRiNOTMtE29iHF6at7wELPvXRo0aC9u');

insert into Rol (idRol, nombreRol) values (1, 'ROL_USER');
insert into Rol (idRol, nombreRol) values (2,'ROL_ADMIN');

insert into Cliente_rol (idRol, idCliente) values (1,2);
insert into Cliente_rol (idRol, idCliente) values (2,1);

insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Camara', 53, 34,'Fotografia','Esto es una camara');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Pantalla', 153, 3,'Perifericos','Esto es una pantalla');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Teclado Gamer', 253, 4,'Perifericos','Esto es un teclado');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Portatil hp v7', 353, 30,'Portatiles','Este es un portatil');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Portatil Acer 45', 453, 31,'Portatiles','Este es un portatil');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Xbox one + 6 juegos', 553, 14,'Consolas','Esto es una consola');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Movil hn7', 653, 3,'Smartphones','Esto es un telefono');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Movil Apple 78', 753, 4,'Smartphones','Esto es un telefono');
