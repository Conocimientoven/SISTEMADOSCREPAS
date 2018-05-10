CREATE DATABASE SDCDB
USE SDCDB

DROP DATABASE SDCDB

--COSAS DE LA INTERFAZ ADMINISTRAR USUARIOS*********************************************************************************
create table Usuarios
(
Id_Usuario varchar(20),
Nombre_Usuario varchar(100),
Clave_Usuario varchar(30),
Tipo_Usuario varchar(13),
primary key(Id_Usuario)
)

INSERT INTO Usuarios VALUES('adminax','Aurea De La Mora','adminax','Administrador')
INSERT INTO Usuarios VALUES('seller','Kira Yoshikage','seller','Vendedor')

SELECT * FROM Usuarios

delete from Usuarios where Id_Usuario='adminax'

drop table usuarios

--OBTAINING THE ROWCOUNT PROCEDURE------------------------
GO
CREATE PROCEDURE getRowCount
AS BEGIN
SELECT COUNT(*) FROM Usuarios WITH (NOLOCK)
END
GO

execute getRowcount

-----------------------------------------------------------

--OBTAINING THE ACCESS PROCEDURE---------------------------
GO
CREATE PROCEDURE selectionForAccess
AS BEGIN
SELECT Id_Usuario,Clave_Usuario, Tipo_Usuario FROM Usuarios
END
GO

execute selectionForAccess
-----------------------------------------------------------


--NEW USER------------------------
GO
CREATE PROCEDURE insertNewUser @ID varchar(20), @Nombre varchar(50), @Clave varchar(30), @Tipo varchar(13)
AS BEGIN
INSERT INTO Usuarios VALUES(@ID,@Nombre,@Clave,@Tipo)
END
GO


CREATE TRIGGER checkInsert ON Usuarios
AFTER INSERT
AS
BEGIN
SET NOCOUNT ON
IF((SELECT Nombre_Usuario FROM INSERTED)!='' OR ((SELECT LEN(Nombre_Usuario) FROM INSERTED)<10))
print 'Se requiere escribir un nombre de usuario de al menos 10 caracteres'
rollback
end



INSERT INTO Usuarios VALUES('kira','rrrrrrrrr','kira','Administrador')



drop trigger checkInsert

create trigger checkInsertOnUnderAge on estudiantes
after insert
as
begin
set nocount on
if((select edad from inserted)>18)
print 'YOU CANNOT ADD THIS USER'
rollback
end






drop procedure inserNewUser
GO

execute insertNewUser 3, 'Leo', 'Leo', 'Administrador'
INSERT INTO Usuarios VALUES(5,'Seller23','Seller','Vendedor')
INSERT INTO Usuarios VALUES(10,'Admin','Admin','Administrador')

-----------------------------------------------------------

--MODIFY USER------------------------
GO
CREATE PROCEDURE modifyUser @ID varchar(20), @Nombre varchar(20), @Clave varchar(30), @Tipo varchar(13)
AS BEGIN
UPDATE Usuarios SET Nombre_Usuario=@Nombre, Clave_Usuario=@Clave, Tipo_Usuario=@Tipo where Id_Usuario=@ID
END
GO
-----------------
drop procedure modifyUser
GO

execute modifyUser 2, 'Ra', 'Ra', 'Vendedor'
INSERT INTO Usuarios VALUES(2,'RAasdf','Seller','Vendedor')

-----------------------------------------------------------


--DELETE USER------------------------
GO
CREATE PROCEDURE deleteUser @ID varchar(20)
AS BEGIN
DELETE FROM Usuarios WHERE Id_Usuario=@ID
END
GO

drop procedure deleteUser
GO

execute deleteUser admina
-----------------------------------------------------------

--CONSULT USER------------------------
GO
CREATE PROCEDURE consultUser
AS BEGIN
SELECT ID_Usuario, Nombre_Usuario,Clave_Usuario,Tipo_Usuario FROM Usuarios 
END
GO

drop procedure consultUser
GO

execute consultUser
INSERT INTO Usuarios VALUES(1,'Seller','Seller','Vendedor')

-----------------------------------------------------------


DELETE FROM Usuarios where Id_Usuario=0




--TERMINAN LAS COSAS DE LA INTERFAZ ADMINISTRAR USUARIOS********************************************************************************










--COSAS DE LA INTERFAZ ADMINISTRAR BASE DE BD*********************************************************************************



--BACKUP DATABASE------------------------
ALTER DATABASE SDCDB SET RECOVERY FULL; 

GO
ALTER PROCEDURE backupDatabase @ruta varchar(100)
AS BEGIN
BACKUP DATABASE SDCDB TO DISK = @ruta
END
GO

BACKUP DATABASE SDCDB TO DISK = 'C:\Users\Success\Desktop\SDCDB.BAK'

execute backupDatabase 'C:\Users\Success\Desktop\SDCDB.BAK'
-----------------------------------------------------------

--RESTORE DATABASE------------------------
GO
ALTER PROCEDURE restoreDatabase @ruta varchar(100)
AS BEGIN
SET NOCOUNT ON
RESTORE DATABASE SDCDB FROM DISK = @ruta
END
GO


DROP DATABASE SDCDB

RESTORE DATABASE SDCDB FROM DISK = 'C:\Users\Success\Desktop\SDCDB.BAK'
RESTORE DATABASE SDCDB FROM DISK = 'C:\BACKUPS\SDCDB.BAK'
execute restoreDatabase 'C:\Users\Success\Desktop\SDCDB.bak' 
-----------------------------------------------------------






--TERMINAN LAS COSAS DE LA INTERFAZ ADMINISTRAR BD********************************************************************************
















--COSAS DE LA INTERFAZ ADMINISTRAR PRODUCTOS***********************************************************************


create table Productos
(
Id_Producto varchar(20),
Descrip_Producto varchar(100),
Cantidad_Producto varchar(10),
Unidad_Medida_Producto varchar(6),
primary key(Id_Producto)
)
drop table Productos




INSERT INTO Productos VALUES('Nutella','Es uno de los ingredientes más solicitados en las crepas. Es vital cuidarlo.','5','Kilos')

SELECT * FROM Productos






--INSERTAR PRODUCTO\
RESTORE DATABASE SDCDB FROM DISK = 'C:\Users\Success\Desktop\SDCDB.BAK'

GO
CREATE PROCEDURE insertNewProduct @ID varchar(20), @Descrip varchar(100), @Cantidad varchar(10), @Unidad_Medida varchar(6)
AS BEGIN
INSERT INTO Usuarios VALUES(@ID,@Descrip,@Cantidad,@Unidad_Medida)
END
GO

DROP PROCEDURE insertNewProducto

EXECUTE insertNewProduct('Crema de cacahuate', 'Sirve para la crepa 13', '2','Litros')
--TERMINA INSERTAR PRODUCTO






--TERMINAN LAS COSAS DE LA INTERFAZ ADMINISTRAR PRODUCTOS*****************************************************


--*****************************************************INTERFAZ VENDEDOR*****************************************************

create table Pedidos
(
Id_Pedido varchar(20),
Estado_Pago varchar(9),
Estado_Entrega varchar(12),
Fecha_Pedido varchar(20),
Costo_Pedido int,
primary key(Id_Pedido)
)
drop table Pedidos

SELECT Id_Pedido from Pedidos

SELECT Id_Pedido,Costo_Pedido FROM Pedidos where Fecha_Pedido='2018-05-08'
SELECT Id_Pedido,Costo_Pedido FROM Pedidos WHERE Fecha_Pedido='"+a+"-"+b+"-"+c+"'


SELECT * FROM Pedidos order by len(Id_Pedido),Id_Pedido

SELECT * FROM Pedidos where (Estado_Pago='No pagado' OR Estado_Entrega='No entregado')


SELECT COUNT(*) FROM Pedidos WITH (NOLOCK) WHERE (Estado_Pago='No pagado' OR Estado_Entrega='No entregado')

INSERT INTO Pedidos VALUES('0','Pagado','Entregado',(SELECT CONVERT (date, SYSDATETIME())),0)
INSERT INTO Pedidos VALUES(((SELECT TOP 1 Id_Pedido FROM Pedidos ORDER BY Id_Pedido DESC)+1),'No Pagado','No Entregado',(SELECT CONVERT (date, SYSDATETIME())),100)

SELECT COUNT(*) FROM Pedidos WITH (NOLOCK) WHERE (Estado_Pago='No pagado' OR Estado_Entrega='No entregado')
--************AGREGAR UN NUEVO PEDIDO********************
GO
ALTER PROCEDURE insertarPedido
AS BEGIN
INSERT INTO Pedidos VALUES
(
	((SELECT TOP 1 Id_Pedido FROM Pedidos ORDER BY cast(Id_Pedido as int) DESC)+1),'No pagado','No entregado',(SELECT CONVERT (date, SYSDATETIME())),0
)
END
GO



SELECT * FROM Pedidos where (Estado_Pago='No pagado' OR Estado_Entrega='No entregado') ORDER BY cast(Id_Pedido as int) DESC
SELECT Id_Pedido FROM Pedidos  ORDER BY cast(Id_Pedido as int) DESC





EXECUTE insertarPedido

drop procedure insertarPedido

select * from Pedidos order by len(Id_Pedido),Id_Pedido

SELECT COUNT(*) FROM Pedidos WITH (NOLOCK)
execute getRowCount

--************FIN AGREGAR UN NUEVO PEDIDO********************


--**********ACTUALIZAR PEDIDO
GO
ALTER PROCEDURE actualizarPedidos @Id_Pedido varchar(20)
AS BEGIN
UPDATE Pedidos SET Costo_Pedido=(SELECT SUM(Costo_Crepa) FROM Crepas WHERE Id_Pedido=@Id_Pedido) WHERE Id_Pedido=@Id_Pedido
END
GO


SELECT SUM(Costo_Pedido) FROM Pedidos WHERE Fecha_Pedido='2018-05-09'
select * from Crepas where Id_Pedido='5'
actualizarPedidos 3

--**********FIN ACTUALIZAR PEDIDO


--********************************CANCELAR PEDIDO**********************
GO
CREATE PROCEDURE cancelarPedido @Id_Pedido varchar(20)
AS BEGIN
UPDATE Pedidos SET Estado_Entrega='CANCELADO', Estado_Pago='CANCELADO' where (Id_Pedido=@Id_Pedido)
END
GO



--********************************FIN PEDIDO CANCELADO********************************

create table Crepas
(
Id_Crepa varchar(20),
Costo_Crepa int,
Cantidad_Crepa int,
Ingredientes_Crepa varchar (100),
Adornos_Crepa varchar(100),
LugarConsumo_Crepa varchar(10),
Id_Pedido varchar(20),
foreign key (Id_Pedido) REFERENCES Pedidos(Id_Pedido),
)

drop table Crepas


--************AGREGAR UNA CREPA A UN PEDIDO********************
GO
CREATE PROCEDURE insertarCrepa @Id_Crepa varchar(20), @Costo_Crepa int, @Cantidad_Crepa int, @Ingredientes_Crepa varchar(100), @Adornos_Crepa varchar(100), @LugarConsumo_Crepa varchar(10),@Id_Pedido varchar(20)
AS BEGIN
INSERT INTO Crepas VALUES
(
	@Id_Crepa, @Costo_Crepa,@Cantidad_Crepa, @Ingredientes_Crepa, @Adornos_Crepa, @LugarConsumo_Crepa,@Id_Pedido
)
END
GO



SELECT * FROM Crepas
EXECUTE insertarCrepa 'Crepa1','55','1','Nutella,Fresa,1BolitaNieve,1BolitaNieve','Hersheys','Llevar','28'

drop procedure insertarCrepa


SELECT Id_Crepa FROM Crepas WHERE Id_Pedido='28' ORDER BY cast(Id_Crepa AS varchar) DESC


--*************FIN AGREGAR UNA CREPA A UN PEDIDO********************





--**MODIFICAR CREPA

GO
CREATE PROCEDURE modificarCrepa @Id_Crepa varchar(20), @Costo_Crepa int, @Cantidad_Crepa int, @Ingredientes_Crepa varchar(100), @Adornos_Crepa varchar(100), @LugarConsumo_Crepa varchar(10),@Id_Pedido varchar(20)
AS BEGIN
UPDATE Crepas SET 
Costo_Crepa=@Costo_Crepa, 
Cantidad_Crepa=@Cantidad_Crepa, 
Ingredientes_Crepa=@Ingredientes_Crepa, 
Adornos_Crepa=@Adornos_Crepa, 
LugarConsumo_Crepa=@LugarConsumo_Crepa
WHERE (Id_Crepa=@Id_Crepa AND Id_Pedido=@Id_Pedido)
END
GO

SELECT * FROM Crepas
DELETE FROM Crepas where Id_Crepa='Personalizada'
execute modificarCrepa 'Personalizada',30,1,'Nutella','','Llevar','1'

--**FIN MODIFICAR CREPA












--*************CREPA ENTREGADA********************
GO
CREATE PROCEDURE deliveredCrepe @Id_Pedido varchar(20)
AS BEGIN
UPDATE Pedidos SET Estado_Entrega='Entregado' where (Id_Pedido=@Id_Pedido)
END
GO
--*************FIN CREPA ENTREGADA********************

--*************CREPA ENTREGADA********************
GO
CREATE PROCEDURE paidCrepe @Id_Pedido varchar(20)
AS BEGIN
UPDATE Pedidos SET Estado_Pago='Pagado' where (Id_Pedido=@Id_Pedido)
END
GO

SELECT * FROM Pedidos

execute paidCrepe 1
execute deliveredCrepe 2
--*************FIN CREPA ENTREGADA********************



--*******************************RELLENAR LISTA DE CREPAS DE ACUERDO A SU PEDIDO********************************

GO
ALTER PROCEDURE consultarCrepa @Id_Pedido varchar(20), @Id_Crepa varchar(20)
AS BEGIN
SELECT * FROM Crepas WITH (NOLOCK) WHERE (Id_Pedido=@Id_Pedido AND Id_Crepa=@Id_Crepa)
END
GO





execute consultarCrepa '3','Crepa3'


--*******************************FIN RELLENAR LISTA DE CREPAS DE ACUERDO A SU PEDIDO********************************




--*****************************************************TERMINA INTERFAZ VENDEDOR*****************************************************