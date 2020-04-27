
insert into Cliente (nombre, apellidos, fechaNacimniento, email, banco, titular, codigoSeguridad, numTarjeta, direccionEnvio, direccionFacturacion, nombreUsuario, password) values ('Alberto','G M','1992-06-05','alberto@gmail.com','Bankia','AlbertGM',111,1000999900001111,'Av.Europa','Av.Europa','Albert', 'A5GM');
insert into Cliente (nombre, apellidos, fechaNacimniento, email, banco, titular, codigoSeguridad, numTarjeta, direccionEnvio, direccionFacturacion, nombreUsuario, password) values ('Daniel','N','1997-08-05','daniel@gmail.com','Bankia','DaniN',222,2200999900001211,'Av.America','Av.America','Dani', '$2a$10$HZKL6onvjzTtwWrFPzZw.eTxkF2rZeLFfHJagwAoImFKhKGXWIkeK ');
insert into Cliente (nombre, apellidos, fechaNacimniento, email, banco, titular, codigoSeguridad, numTarjeta, direccionEnvio, direccionFacturacion, nombreUsuario, password) values ('Marcos','F P','1992-07-07','marcos@gmail.com','Bankia','MarcosFP',333,3300999900001311,'Av.FP','Av.FP','Marcos', '12345');

insert into Rol (idrol, nombre_rol ) values (1, 'ROL_USER');
insert into Rol (idrol, nombre_rol ) values (2,'ROL_ADMIN');

insert into Cliente_rol (ID_ROL, ID_CLIENTE ) values (1,1);
insert into Cliente_rol (ID_ROL, ID_CLIENTE ) values (1,2);
insert into Cliente_rol (ID_ROL, ID_CLIENTE ) values (2,1);
insert into Cliente_rol (ID_ROL, ID_CLIENTE ) values (2,2);
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Camara', 53, 34,'Fotografia','Esto es una camara');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Pantalla', 153, 3,'Perifericos','Esto es una pantalla');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Teclado Gamer', 253, 4,'Perifericos','Esto es un teclado');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Portatil hp v7', 353, 30,'Portatiles','Este es un portatil');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Portatil Acer 45', 453, 31,'Portatiles','Este es un portatil');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Xbox one + 6 juegos', 553, 14,'Consolas','Esto es una consola');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Movil hn7', 653, 3,'Smartphones','Esto es un telefono');
insert into Producto(nombreProducto, precio, stock, categoria, descripcion) values ('Movil Apple 78', 753, 4,'Smartphones','Esto es un telefono');
