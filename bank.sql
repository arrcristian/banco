CREATE DATABASE BANK;

USE BANK;

CREATE TABLE CLIENTES(
id INT PRIMARY KEY AUTO_INCREMENT,
nombre varchar (30) ,
apellido_paterno varchar (20),
apellido_materno varchar (20),
fecha_nacimiento Date,
calle VARCHAR (100) NOT NULL,
numero_casa VARCHAR (10) NOT NULL,
colonia VARCHAR (100) NOT NULL,
edad bigint,
contraseña varchar (8)
);

CREATE TABLE CUENTAS(
id INT PRIMARY KEY AUTO_INCREMENT,
fechaHoraApertura date,
estado ENUM('activa','cancelada'),
saldo float,
numero varchar (16),
IdCliente INT,
FOREIGN KEY(IdCliente) REFERENCES clientes(id)
);


CREATE TABLE RETIROS(
id INT PRIMARY KEY AUTO_INCREMENT,
folio varchar (10),
contraseña varchar (8),
fechaRealización date,
estado ENUM('cobrado','no cobrado'),
monto float,
idCuenta INT,
FOREIGN KEY(idCuenta) REFERENCES cuentas(id)
);

CREATE TABLE TRANSFERENCIAS(
id INT PRIMARY KEY AUTO_INCREMENT,
fechaRealizacion date,
monto float,
CuentaOrigen int,
CuentaDestino int,
FOREIGN KEY(CuentaOrigen) REFERENCES cuentas(id),
FOREIGN KEY(CuentaOrigen) REFERENCES cuentas(id)
);


DELIMITER $$
CREATE PROCEDURE transferir(IN monto float, IN cuentaA varchar(16), IN cuentaB varchar(16))
# Transacción para transferir un monto de la cuentaA a la cuentaB
BEGIN
DECLARE saldo_actual_cuentaA float;
START TRANSACTION;
IF EXISTS (SELECT * FROM Cuentas WHERE numero=cuentaA) AND
EXISTS (SELECT * FROM Cuentas WHERE numero=cuentaB) THEN
SELECT saldo INTO saldo_actual_cuentaA
FROM cuentas WHERE numero = cuentaA FOR UPDATE;
IF saldo_actual_cuentaA >= monto THEN
UPDATE cuentas SET saldo = saldo - monto WHERE numero=cuentaA;
UPDATE cuentas SET saldo = saldo + monto WHERE numero=cuentaB;
SELECT 'La transferencia se realizó con exito' AS resultado;
ELSE
SELECT 'Saldo insuficiente para realizar la transferencia' AS resultado;
END IF;
ELSE
SELECT 'Error: cuenta inexistente;' AS resultado;
END IF;
COMMIT;
END $$
DELIMITER ;



