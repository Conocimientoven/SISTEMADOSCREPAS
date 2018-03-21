CREATE DATABASE SDCDB
USE SDCDB


create table Usuarios
(
Id_Usuario int,
Nombre_Usuario varchar(20),
Clave_Usuario varchar(30),
Tipo_Usuario varchar(13)
)

INSERT INTO Usuarios VALUES(0,'Admin','Admin','Administrador')
INSERT INTO Usuarios VALUES(1,'Seller','Seller','Vendedor')

SELECT * FROM Usuarios

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
SELECT Nombre_Usuario,Clave_Usuario, Tipo_Usuario FROM Usuarios
END
GO

execute selectionForAccess
-----------------------------------------------------------


--NEW USER------------------------
GO
CREATE PROCEDURE insertNewUser @ID int, @Nombre varchar(20), @Clave varchar(30), @Tipo varchar(13)
AS BEGIN
INSERT INTO Usuarios VALUES(@ID,@Nombre,@Clave,@Tipo)
END
GO

drop procedure inserNewUser
GO

execute insertNewUser 3, 'Leo', 'Leo', 'Administrador'
INSERT INTO Usuarios VALUES(1,'Seller','Seller','Vendedor')
INSERT INTO Usuarios VALUES(0,'Admin','Admin','Administrador')

-----------------------------------------------------------

--MODIFY USER------------------------
GO
CREATE PROCEDURE modifyUser @ID int, @Nombre varchar(20), @Clave varchar(30), @Tipo varchar(13)
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
CREATE PROCEDURE deleteUser @ID int
AS BEGIN
DELETE FROM Usuarios WHERE Id_Usuario=@ID
END
GO

drop procedure deleteUser
GO

execute deleteUser 1
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

-- Esto hace un backup de nuestra base de datos
BACKUP database SDCDB
to disk = 'C:\BACKUPS\SDCDB.bak'

-- drop database sistec
-- esto elimina la base de datos y si no hay backup valio :'c


-- Esto restaura la base de datos
restore database SDCDB
FROM disk = 'C:\BACKUPS\SDCDB.bak'
WITH REPLACE