
insert into Cliente (nombre, apellidos, fechaNacimniento, email, banco, titular, codigoSeguridad, numTarjeta, direccionEnvio, direccionFacturacion, nombreUsuario, password) values ('admin','admin','1992-06-05','admin@gmail.com','admin','admin',111,1000999900001111,'admin','admin','admin', '$2a$10$x81Gc/y2Abgous23qb/6DOAWHm9UlzZl35wRo4emOUAIglRce/Pzu');
insert into Cliente (nombre, apellidos, fechaNacimniento, email, banco, titular, codigoSeguridad, numTarjeta, direccionEnvio, direccionFacturacion, nombreUsuario, password) values ('user','user','1997-08-05','usergmail.com','user','user',222,2200999900001211,'user','user','user', '$2a$10$0prZ1MMAqlXxVtLwv8o0ZOrRiNOTMtE29iHF6at7wELPvXRo0aC9u');

insert into Rol (idRol, nombreRol) values (1, 'ROL_USER');
insert into Rol (idRol, nombreRol) values (2,'ROL_ADMIN');

insert into Cliente_rol (idRol, idCliente) values (1,2);
insert into Cliente_rol (idRol, idCliente) values (2,1);

insert into Producto(nombreProducto, precio, stock, descripcion) values ('Camara', 53, 34,'Esto es una camara');
insert into Producto(nombreProducto, precio, stock, descripcion) values ('Pantalla', 153, 3,'Esto es una pantalla');
insert into Producto(nombreProducto, precio, stock, descripcion) values ('Teclado Gamer', 253, 4,'Esto es un teclado');
insert into Producto(nombreProducto, precio, stock, descripcion) values ('Portatil hp v7', 353, 30,'Este es un portatil');
insert into Producto(nombreProducto, precio, stock, descripcion) values ('Portatil Acer 45', 453, 31,'Este es un portatil');
insert into Producto(nombreProducto, precio, stock, descripcion) values ('Xbox one + 6 juegos', 553, 14,'Esto es una consola');
insert into Producto(nombreProducto, precio, stock, descripcion) values ('Movil hn7', 653, 3,'Esto es un telefono');
insert into Producto(nombreProducto, precio, stock, descripcion) values ('Movil Apple 78', 753, 4,'Esto es un telefono');

insert into Categoria(nombre, descripcion) values ('Fotografia','Es arte');
insert into Categoria(nombre, descripcion) values ('Perifericos','Son utiles');
insert into Categoria(nombre, descripcion) values ('Portatiles','Son portables');
insert into Categoria(nombre, descripcion) values ('Consolas','Son divertidas');
insert into Categoria(nombre, descripcion) values ('Smartphones','Son multifuncionales');


insert into Categoria_producto (idCategoria, idProducto) values (1,1);
insert into Categoria_producto (idCategoria, idProducto) values (2,2);
insert into Categoria_producto (idCategoria, idProducto) values (2,3);
insert into Categoria_producto (idCategoria, idProducto) values (3,4);
insert into Categoria_producto (idCategoria, idProducto) values (3,5);
insert into Categoria_producto (idCategoria, idProducto) values (4,6);
insert into Categoria_producto (idCategoria, idProducto) values (5,7);
insert into Categoria_producto (idCategoria, idProducto) values (5,8);
