---------- SDCDB
create database SDCDB
use SDCDB
---------- Fin SDCDB

----------Interfaz Administrar Usuarios
create table Usuarios
(
Id_Usuario varchar(20),
Nombre_Usuario varchar(50),
Clave_Usuario varchar(30),
Tipo_Usuario varchar(13),
primary key(Id_Usuario)
)
------------- Obtaining getRowCount 
go
create procedure getRowCount
as begin
select count(*) from Usuarios with (nolock) end
go

execute getRowcount
---------- Fin Obtaining getRowcount

---------- Obtaining the Access procedure
go
create procedure selectionForAccess2
as begin
select Id_Producto,
Descripción,
Cantidad_Producto,
Unidad_Medida 
from Productos
en
go
---------- Fin Obtaining Access Procedure

--------- New user procedure
go
create procedure insertNewUser 
@ID varchar(20), 
@Nombre varchar(50), 
@Clave varchar(30), 
@Tipo varchar(13)
as begin
insert into Usuarios 
values(@ID,
@Nombre,
@Clave,
@Tipo) end
go
---------- Fin Inser New user procedure
---------- Trigger para validar los usuarios, nombre
create trigger checkInsert on Usuarios
after insert
as begin
set nocount on
if((select Nombre_Usuario from INSERTED)!='' 
OR ((select len(Nombre_Usuario) from INSERTED) < 10))
print 'Se requiere escribir un nombre de usuario de al menos 10 caracteres'
rollback end
---------- Fin trigger para validar usuarios, nombre

---------- Trigger para validar estudiantes, edad
--create trigger checkInsertOnUnderAge on estudiantes
--after insert
--as
--begin
--set nocount on
--if((select edad from inserted)>18)
--print 'YOU CANNOT ADD THIS USER'
--rollback
--end---------- Fin trigger para validar estudiantes, edad



---------- Procedimiento para modificar usuarios
go
create procedure modifyUser 
@ID varchar(20), @Nombre varchar(20),
@Clave varchar(30), 
@Tipo varchar(13)
as begin
update Usuarios set 
Nombre_Usuario=@Nombre, 
Clave_Usuario=@Clave, 
Tipo_Usuario=@Tipo 
where Id_Usuario=@ID end
go
---------- Fin procedimiento para modificar usuarios

---------- Procedimiento para eliminar u usuario
go
create procedure deleteUser 
@ID varchar(20)
as begin
delete 
from Usuarios where Id_Usuario=@ID end
go
---------- Fin procedimiento para eliminar un usuario

---------- Procedimiento para consultar un usuario
go
create procedure consultUser
as begin
select ID_Usuario, 
Nombre_Usuario,
Clave_Usuario,
Tipo_Usuario
from Usuarios end
go

---------- Fin procedimiento para conultar por un usuario
---------- Fin Interfaz administrar usuarios

---------- Administrar Proveedores interfaz
--create table Proveedores(
--Id_Proveedor varchar(8),
--Nombre_Proveedor varchar(50),
--Teléfono_Proveedor varchar(10),
--Código_Postal varchar(5),
--Ciudad_Proveedor varchar(40),
--Colonia_Proveeddor varchar (40),
--Calle_Proveedor varchar (40),
--Número_Calle varchar (4),
--primary key(Id_Proveedor
--)
---------- Procedimiento para crear un nuevo provedor ----------


go
create procedure addNewProvider
@Id_Proveedor varchar(8),
@Nombre_Proveedor varchar (50),
@Teléfono_Proveedor varchar (10),
@Código_Postal varchar (5),
@Estado_Proveedor varchar (5000),
@Municipio varchar (5000),
@Colonia varchar (5000),
@Calle varchar (200),
@Número_Calle varchar (5)
as begin
insert into Proveedores 
values(
@Id_Proveedor,
@Nombre_Proveedor,
@Teléfono_Proveedor,
@Código_Postal,
@Estado_Proveedor,
@Municipio,
@Colonia,
@Calle,
@Número_Calle
) end
go
---------- Fin procedimiento para crear un nuevo proveedor ----------
---------- Procedimiento para modificar un proveedor
go
create procedure newModifyProvidersProcedure
@Id_Proveedor varchar(8),
@Nombre_Proveedor varchar (50),
@Teléfono_Proveedor varchar (10),
@Código_Postal varchar (5),
@Estado_Proveedor varchar (5000),
@Municipio varchar (5000),
@Colonia varchar (5000),
@Calle varchar (200),
@Número_Calle varchar (5)
as begin
update Proveedores set 
Id_Proveedor = @Id_Proveedor,
Nombre_Proveedor = @Nombre_Proveedor,
Teléfono_Proveedor = @Teléfono_Proveedor,
Código_Postal = @Código_Postal,
Estado_Proveedor = @Estado_Proveedor,
Municipio = @Municipio,
Colonia = @Colonia,
Calle = @Calle,
Número_Calle = @Número_Calle
where Id_Proveedor = @Id_Proveedor end
go
---------- Fin procedimiento modifi ar proveedor
---------- Procedimiento para eliminar un proveedor
go
create procedure providersEraser 
@Id_Proveedor varchar(8)
as begin
delete 
from Proveedores where Id_Proveedor = @Id_Proveedor end
go
---------- Fin procedimiento para eliminar un proveedor
---------- Procedimiento para consultar un proveedor
select * from Proveedores
go
create procedure consultProvider2
as begin
select 
Id_Proveedor, 
Nombre_Proveedor,
Teléfono_Proveedor,
Código_Postal
Estado_Proveedor,
Municipio,
Colonia,
Calle,
Número_Calle
from Proveedores end
go
execute consultProvider2
insert into Proveedores values ('15290881','Ramón García de Alba Castrejón','3411252145','49020','Jalisco','Zapotlán el grande','Infonavit','Moctezuma','644')
---------- Procedimiento proveedores ----------
go
create procedure getRowCountProviders2
as begin
select count(*) from Proveedores with (nolock) end
go
---------- Fin procedimiento proveedores ----------
--------- Fin procedimiento para consultar un proveedor
--------- Fin interfaz administrar proveedores

--------- Administrar base de datos
--------- Procedimiento para respaldar base de datos 
go
create procedure backupDatabase
as begin
backup database SDCDB to disk = 'C:\respaldosSDCDB\SDCDB.BAK'
with differential end
go
---------- Fi procedimiento para respaldar la base de datos
---------- Procedimiento pra restaurar la babse de datos
go
create procedure restoreDatabase2
as begin
restore database SDCDB from disk = 'C:\\ftpramon\rdos.bak' with replace end
go
--------- Fin procedimiento para restaurar la base de datos
---------- Fin interfaz Administrar base de datos
---------- Ejemplos de la clase de juanito ----------

----- Aquín se respalda la base de datos -----
--backup database SDCDB to disk = 'C:\BACKUPS\SDCDB.bak'
----- Fin respaldar base de datos -----

----- Esto restaura la base de datos -----
--restore database SDCDB from disk = 'C:\BACKUPS\SDCDB.bak' with replace
----- Fin restaurar la base de datos -----

--TERMINAN LAS COSAS DE LA INTERFAZ ADMINISTRAR PRODUCTOS*****************************************************

------Administrar Productos
drop table Productos
create table Productos(
Id_Producto varchar(30),
Descripción varchar(300),
Cantidad_Producto varchar(12),
Unidad_Medida varchar (20),
primary key (Id_Producto)
)


----Agregar un producto procedure
go
create procedure newProducts3
@Id varchar(30), 
@Descripción varchar(300), 
@Cantidad varchar(12), 
@Unidad_Medida varchar(20)
as begin
insert into Productos values(@Id,@Descripción,@Cantidad,@Unidad_Medida) end
go

execute newProduct 'bote de pasta','pa, bailar','1','Bote'
------ Fin agregar un producto
------ Modificar un prodcuto 
--drop procedure modifyProduct
go
create procedure modifyProducts3
@Id varchar(30), 
@Descripción varchar(300), 
@Cantidad varchar(100),
@Unidad_Medida varchar (13)
as begin
UPDATE Productos set 
Descripción = @Descripción, 
Cantidad_Producto = @Cantidad, 
Unidad_Medida = @Unidad_Medida
where Id_Producto = @Id end
go
------ Fin modificar un producto
------ Eliminar un producto 
--drop procedure deleteProduct
select * from Productos
go
create procedure deleteProduct3 @Id varchar(20)
as begin
delete from Productos where Id_Producto = @Id end
go
------ Fin eliminar un producto
------ Consultar un producto
--drop procedure consultProducts
go
create procedure consultProducts3
as begin
select Id_Producto, 
Descripción,
Cantidad_Producto,
Unidad_Medida
from Productos end
go

select * from Productos
execute consultProducts

------ Fin consultar un producto
------ Contador de renglones 
go
create procedure getProductosCountrows3
as begin
select count(*) from Productos with (nolock) end
go

------ Fin contador de renglones
------ Fin administrar productos
---------- Procedimiento CódigoPostal
go
create procedure consultPostalCodes
as begin
select 
CodigoPostal,
Colonia,
Municipio,
Estado
from CodigosPostales end
go
execute consultPostalCodes
select * from CodigosPostales
--------- Fin procedimiento códigoPostal
---------- getCounterRow Postal codes --------
go
create procedure getCount
as begin
select count(*) from CodigosPostales with (nolock) end
go
---------- Fin getCounterRow Postal codes --------