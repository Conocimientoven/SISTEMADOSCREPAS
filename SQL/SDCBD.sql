CREATE DATABASE SDCDB
USE SDCDB



--COSAS DE LA INTERFAZ ADMINISTRAR USUARIOS*********************************************************************************
create table Usuarios
(
Id_Usuario varchar(20),
Nombre_Usuario varchar(50),
Clave_Usuario varchar(30),
Tipo_Usuario varchar(13),
primary key(Id_Usuario)
)

INSERT INTO Usuarios VALUES('admina','Aurea De La Mora','admin','Administrador')
INSERT INTO Usuarios VALUES('seller','Kira Yoshikage','seller','Vendedor')

SELECT * FROM Usuarios

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
ALTER PROCEDURE selectionForAccess
AS BEGIN
SELECT Id_Usuario,Clave_Usuario, Tipo_Usuario FROM Usuarios
END
GO

execute selectionForAccess
-----------------------------------------------------------


--NEW USER------------------------
GO
ALTER PROCEDURE insertNewUser @ID varchar(20), @Nombre varchar(50), @Clave varchar(30), @Tipo varchar(13)
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
ALTER PROCEDURE modifyUser @ID varchar(20), @Nombre varchar(20), @Clave varchar(30), @Tipo varchar(13)
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
ALTER PROCEDURE deleteUser @ID varchar(20)
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
GO
ALTER PROCEDURE backupDatabase
AS BEGIN
BACKUP DATABASE EDSI TO DISK = 'C:\BACKUPS\EDSI.BAK' WITH DIFFERENTIAL
END
GO

execute backupDatabase
-----------------------------------------------------------

--RESTORE DATABASE------------------------
GO
CREATE PROCEDURE restoreDatabase
AS BEGIN
RESTORE DATABASE EDSI FROM DISK = 'C:\BACKUPS\SDCDB.bak' WITH REPLACE
END
GO

execute restoreDatabase
-----------------------------------------------------------






--EJEMPLOS XDXDX



-- Esto hace un backup de nuestra base de datos
BACKUP database SDCDB
to disk = 'C:\BACKUPS\SDCDB.bak'

-- drop database sistec
-- esto elimina la base de datos y si no hay backup valio :'c


-- Esto restaura la base de datos
restore database SDCDB
FROM disk = 'C:\BACKUPS\SDCDB.bak'
WITH REPLACE





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






--INSERTAR PRODUCTO
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