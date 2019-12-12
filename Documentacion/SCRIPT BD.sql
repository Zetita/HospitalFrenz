CREATE DATABASE `hospitalfrenz`;
 
 CREATE TABLE `hospitalfrenz`.`provincias` (
  `id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(50) NOT NULL ,
  `codigo31662` CHAR(4) NOT NULL ,
  CONSTRAINT `PK_Provincias` PRIMARY KEY (`id`) ,
  UNIQUE INDEX `codigo31662_UNIQUE` (`codigo31662` ASC));

CREATE TABLE `hospitalfrenz`.`localidades` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `provincia_id` TINYINT UNSIGNED NOT NULL ,
  `nombre` VARCHAR(50) NOT NULL ,
  `codigopostal` SMALLINT(6) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_localidades_provincias_idx` (`provincia_id` ASC) ,
  CONSTRAINT `fk_localidades_provincias`
    FOREIGN KEY (`provincia_id` )
    REFERENCES `provincias` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `hospitalfrenz`.`sedes` (
  `IDSede` INT NOT NULL,
  `NombreSede` VARCHAR(50) NOT NULL,
  `DireccionSede` VARCHAR(40) NOT NULL,
  `IDLocalidad` INT(10) UNSIGNED NOT NULL,
  `Estado` TINYINT NOT NULL,
   CONSTRAINT `PK_Sedes ` PRIMARY KEY (`IDSede`));

 
CREATE TABLE `hospitalfrenz`.`usuarios` (
  `NombreUser` VARCHAR(20) NOT NULL,
  `EmailUser` VARCHAR(40) NOT NULL,
  `DNIUser` VARCHAR(11) NOT NULL,
  `ContraseniaUser` VARCHAR(20) NOT NULL,
  `TipoUser` VARCHAR(20) NOT NULL,
  `EstadoUser` TINYINT NOT NULL,
CONSTRAINT  `U_Usuarios_DNI` UNIQUE (DNIUser),
  CONSTRAINT `PK_Usuarios ` PRIMARY KEY (`NombreUser`));

CREATE TABLE `hospitalfrenz`.`medicos` (
  `DNIMed` VARCHAR(11) NOT NULL,
  `MatriculaMed` VARCHAR(15) NOT NULL,
  `NombreMed` VARCHAR(20) NOT NULL,
  `ApellidosMed` VARCHAR(20) NOT NULL,
  `DireccionMed` VARCHAR(40) NULL,
  `IDLocalidad` INT(10) UNSIGNED NOT NULL,
  `TelefonoMed` VARCHAR(15) NOT NULL,
  `EstadoMed` TINYINT NOT NULL,
  CONSTRAINT `PK_Medicos ` PRIMARY KEY (`MatriculaMed`));

CREATE TABLE `hospitalfrenz`.`pacientes` (
  `DNIPaciente` VARCHAR(11) NOT NULL,
  `NombrePaciente` VARCHAR(20) NOT NULL,
  `ApellidoPaciente` VARCHAR(20) NOT NULL,
  `FechaNacPaciente` DATE NOT NULL,
  `Telefono` VARCHAR(15) NOT NULL,
  `DireccionPaciente` VARCHAR(40) NULL,
  `IDLocalidad` INT(10) UNSIGNED NOT NULL,
  `IDCobertura` INT NOT NULL,
  `EstadoPaciente` TINYINT NOT NULL,
  CONSTRAINT `PK_Paciente ` PRIMARY KEY (`DNIPaciente`));

CREATE TABLE `hospitalfrenz`.`especialidades` (
  `IDEspecialidad` INT NOT NULL,
  `DescripcionEspecialidad` VARCHAR(40) NOT NULL,
  `EstadoEspecialidad` TINYINT NOT NULL,
  CONSTRAINT `PK_Especialidades ` PRIMARY KEY (`IDEspecialidad`));

CREATE TABLE `hospitalfrenz`.`coberturas` (
  `IDCobertura` INT NOT NULL,
  `NombreCobertura` VARCHAR(20) NOT NULL,
  `TipoCobertura` VARCHAR(20) NOT NULL,
  `CostoCobertura` DECIMAL(10,2) NOT NULL,
  `DescripcionCobertura` TEXT NOT NULL,
  CONSTRAINT `PK_Coberturas ` PRIMARY KEY (`IDCobertura`));

CREATE TABLE `hospitalfrenz`.`pacxsed` (
  `DNIPaciente` VARCHAR(11) NOT NULL,
  `IDSede` INT NOT NULL,
CONSTRAINT `PK_PacXSed ` PRIMARY KEY (`DNIPaciente`, `IDSede`));

CREATE TABLE `hospitalfrenz`.`cobxmed` (
  `IDMatriculaMed` VARCHAR(15) NOT NULL,
  `IDCobertura` INT NOT NULL,
  `EstadoCobxMed` TINYINT NOT NULL,
 CONSTRAINT `PK_CobXMed ` PRIMARY KEY (`IDMatriculaMed`, `IDCobertura`));

CREATE TABLE `hospitalfrenz`.`espxmed` (
  `IDMatriculaMed` VARCHAR(15) NOT NULL,
  `IDEspecialidad` INT NOT NULL,
  `EstadoEspxMed` TINYINT NOT NULL,
  CONSTRAINT `PK_EspXMed ` PRIMARY KEY (`IDMatriculaMed`, `IDEspecialidad`));

CREATE TABLE `hospitalfrenz`.`medxsed` (
  `IDSede` INT NOT NULL,
  `IDMatriculaMed` VARCHAR(15) NOT NULL,
  `EstadoMedxSed` TINYINT NOT NULL,
  CONSTRAINT `PK_MedXSed ` PRIMARY KEY (`IDSede`, `IDMatriculaMed`));

CREATE TABLE `hospitalfrenz`.`turnos` (
  `IDTurno` INT NOT NULL,
  `IDSede` INT NOT NULL,
  `IDMatriculaMed` VARCHAR(15) NOT NULL,
  `DNIPaciente` VARCHAR(11) NOT NULL,
  `Fecha` DATE NOT NULL,
  `Hora` TIME NOT NULL,
  `IDEspecialidad` INT NOT NULL,
  `Estado` TINYINT NOT NULL,
  `Asistencia` TINYINT NOT NULL,
 CONSTRAINT `PK_Turnos ` PRIMARY KEY (`IDTurno`,`IDSede`));

 CREATE TABLE `hospitalfrenz`.`horarios` (
  `IDMatriculaMed` VARCHAR(15) NOT NULL,
  `IDSede` INT NOT NULL,
  `IDEspecialidad` INT NOT NULL,
  `Dia` VARCHAR(10) NOT NULL,
  `Hora` TIME NOT NULL,
  `Estado` TINYINT NOT NULL,
 CONSTRAINT `PK_Horarios ` PRIMARY KEY (`IDMatriculaMed`,`Dia`,`Hora`));
 
 
ALTER TABLE `hospitalfrenz`.`espxmed`
ADD CONSTRAINT `FK_espxmed_IDMatMed` FOREIGN KEY (`IDMatriculaMed`) REFERENCES `medicos`(`MatriculaMed`),
ADD CONSTRAINT `FK_espxmed_NumEsp` FOREIGN KEY (`IDEspecialidad`) REFERENCES `especialidades`(`IDEspecialidad`);

ALTER TABLE `hospitalfrenz`.`cobxmed`
ADD CONSTRAINT `FK_CobXMed_MatMed` FOREIGN KEY (`IDMatriculaMed`) REFERENCES `medicos`(`MatriculaMed`),
ADD CONSTRAINT `FK_CobXMed_IDCob` FOREIGN KEY (`IDCobertura`) REFERENCES `coberturas`(`IDCobertura`);

ALTER TABLE `hospitalfrenz`.`medxsed`
ADD CONSTRAINT `FK_MedXSed_IDMatMed` FOREIGN KEY (`IDMatriculaMed`) REFERENCES `medicos`(`MatriculaMed`),
ADD CONSTRAINT `FK_MedXSed_IDSede` FOREIGN KEY (`IDSede`) REFERENCES `sedes`(`IDSede`);


ALTER TABLE `hospitalfrenz`.`pacientes`
ADD CONSTRAINT `FK_Pacientes_PacCob` FOREIGN KEY (`IDCobertura`) REFERENCES `coberturas`(`IDCobertura`),
ADD CONSTRAINT `FK_Pacientes_Localidades` FOREIGN KEY (`IDLocalidad`) REFERENCES `localidades`(`id`);

ALTER TABLE `hospitalfrenz`.`Medicos`
ADD CONSTRAINT `FK_Medicos_Localidades` FOREIGN KEY (`IDLocalidad`) REFERENCES `localidades`(`id`);

ALTER TABLE `hospitalfrenz`.`sedes`
ADD CONSTRAINT `FK_Sedes_Localidades` FOREIGN KEY (`IDLocalidad`) REFERENCES `localidades`(`id`);


ALTER TABLE `hospitalfrenz`.`pacxsed`
ADD CONSTRAINT `FK_PacXSed_DNIPac` FOREIGN KEY (`DNIPaciente`) REFERENCES `pacientes`(`DNIPaciente`),
ADD CONSTRAINT `FK_PacXSed_IDSede` FOREIGN KEY (`IDSede`) REFERENCES `sedes`(`IDSede`);

ALTER TABLE `hospitalfrenz`.`turnos`
ADD CONSTRAINT `FK_Turnos_MatMed` FOREIGN KEY (`IDMatriculaMed`) REFERENCES `medicos`(`MatriculaMed`),
ADD CONSTRAINT `FK_Turnos_DNIPac` FOREIGN KEY (`DNIPaciente`) REFERENCES `pacientes`(`DNIPaciente`),
ADD CONSTRAINT `FK_Turnos_IDSede` FOREIGN KEY (`IDSede`) REFERENCES `sedes`(`IDSede`),
ADD CONSTRAINT `FK_Turnos_NumEsp` FOREIGN KEY (`IDEspecialidad`) REFERENCES `especialidades`(`IDEspecialidad`);


ALTER TABLE `hospitalfrenz`.`horarios`
ADD CONSTRAINT `FK_Horarios_MatMed` FOREIGN KEY (`IDMatriculaMed`) REFERENCES `medicos`(`MatriculaMed`),
ADD CONSTRAINT `FK_Horarios_IDSede` FOREIGN KEY (`IDSede`) REFERENCES `sedes`(`IDSede`),
ADD CONSTRAINT `FK_Horarios_IDEsp` FOREIGN KEY (`IDEspecialidad`) REFERENCES `especialidades`(`IDEspecialidad`);
