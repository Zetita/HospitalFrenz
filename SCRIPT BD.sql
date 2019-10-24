CREATE DATABASE `hospitalfrenz`;
 
CREATE TABLE `hospitalfrenz`.`usuarios` (
  `NombreUser` VARCHAR(20) NOT NULL,
  `EmailUser` VARCHAR(40) NOT NULL,
  `DNIUser` INT NOT NULL,
  `ContraseniaUser` VARCHAR(20) NOT NULL,
  `AdminUser` TINYINT NOT NULL,
  `TipoUser` TINYINT NOT NULL,
CONSTRAINT  `U_Usuarios_DNI` UNIQUE (DNIUser),
  CONSTRAINT `PK_Usuarios ` PRIMARY KEY (`NombreUser`));

CREATE TABLE `hospitalfrenz`.`medicos` (
  `DNIMed` INT NOT NULL,
  `MatriculaMed` INT NOT NULL,
  `NombreMed` VARCHAR(20) NOT NULL,
  `ApellidosMed` VARCHAR(20) NOT NULL,
  `DireccionMed` VARCHAR(40) NULL,
  `IDLocalidadMed` INT NULL,
  `IDProvinciaMed` INT NULL,
  `TelefonoMed` INT NOT NULL,
  `EstadoMed` TINYINT NOT NULL,
  CONSTRAINT `PK_Medicos ` PRIMARY KEY (`MatriculaMed`));



CREATE TABLE `hospitalfrenz`.`pacientes` (
  `DNIPaciente` INT NOT NULL,
  `NombrePaciente` VARCHAR(20) NOT NULL,
  `ApellidoPaciente` VARCHAR(20) NOT NULL,
  `FechaNacPaciente` DATE NOT NULL,
  `Telefono` INT NOT NULL,
  `DireccionPaciente` VARCHAR(40) NULL,
  `IDLocalidadPaciente` INT NULL,
  `IDProvinciaPaciente` INT NULL,
  `IDCobertura` INT NOT NULL,
  `EstadoPaciente` TINYINT NOT NULL,
  CONSTRAINT `PK_Paciente ` PRIMARY KEY (`DNIPaciente`));

CREATE TABLE `hospitalfrenz`.`especialidades` (
  `IDEspecialidad` INT NOT NULL,
  `DescripcionEspecialidad` VARCHAR(40) NOT NULL,
  `EstadoEspecialidad` TINYINT NOT NULL,
  CONSTRAINT `PK_Especialidades ` PRIMARY KEY (`IDEspecialidad`));

CREATE TABLE `hospitalfrenz`.`provincias` (
  `IDProvincia` INT NOT NULL,
  `NombreProvincia` VARCHAR(20) NOT NULL,
  CONSTRAINT `PK_Provincias ` PRIMARY KEY (`IDProvincia`));




CREATE TABLE `hospitalfrenz`.`localidades` (
  `IDProvincia` INT NOT NULL,
  `IDLocalidad` INT NOT NULL,
  `NombreLocalidad` VARCHAR(20) NOT NULL,
  CONSTRAINT `PK_Localidad ` PRIMARY KEY (`IDLocalidad`));

CREATE TABLE `hospitalfrenz`.`sedes` (
  `IDSede` INT NOT NULL,
  `NombreSede` VARCHAR(20) NOT NULL,
  `DireccionSede` VARCHAR(40) NOT NULL,
  `IDLocalidadSede` INT NOT NULL,
  `IDProvinciaSede` INT NOT NULL,
  `Estado` TINYINT NOT NULL,
 CONSTRAINT `PK_Sedes ` PRIMARY KEY (`IDSede`));

CREATE TABLE `hospitalfrenz`.`coberturas` (
  `IDCobertura` INT NOT NULL,
  `NombreCobertura` VARCHAR(20) NOT NULL,
  `TipoCobertura` VARCHAR(20) NOT NULL,
  CONSTRAINT `PK_Coberturas ` PRIMARY KEY (`IDCobertura`));

CREATE TABLE `hospitalfrenz`.`pacxsed` (
  `DNIPaciente` INT NOT NULL,
  `IDSede` INT NOT NULL,
CONSTRAINT `PK_PacXSed ` PRIMARY KEY (`DNIPaciente`, `IDSede`));


CREATE TABLE `hospitalfrenz`.`cobxmed` (
  `IDMatriculaMed` INT NOT NULL,
  `IDCobertura` INT NOT NULL,
  `EstadoCobxMed` TINYINT NOT NULL,
 CONSTRAINT `PK_CobXMed ` PRIMARY KEY (`IDMatriculaMed`, `IDCobertura`));



CREATE TABLE `hospitalfrenz`.`espxmed` (
  `IDMatriculaMed` INT NOT NULL,
  `IDEspecialidad` INT NOT NULL,
  `EstadoEspxMed` TINYINT NOT NULL,
  CONSTRAINT `PK_EspXMed ` PRIMARY KEY (`IDMatriculaMed`, `IDEspecialidad`));

CREATE TABLE `hospitalfrenz`.`medxsed` (
  `IDSede` INT NOT NULL,
  `IDMatriculaMed` INT NOT NULL,
  `EstadoMesxSed` TINYINT NOT NULL,
  CONSTRAINT `PK_MedXSed ` PRIMARY KEY (`IDSede`, `IDMatriculaMed`));




CREATE TABLE `hospitalfrenz`.`historialxpac` (
  `IDTurno` INT NOT NULL,
  `IDMatriculaMed` INT NOT NULL,
  `DNIPaciente` INT NOT NULL,
  `IDSede` INT NOT NULL,
  `IDEspecialidad` INT NULL,
  `Hora` TIME NOT NULL,
  `Fecha` DATE NOT NULL,
  `Estado` TINYINT NOT NULL,
  `Asistencia` TINYINT NOT NULL,
  CONSTRAINT `PK_HistorialxPac ` PRIMARY KEY (`IDTurno`,`IDSede`));

CREATE TABLE `hospitalfrenz`.`turnos` (
  `IDTurno` INT NOT NULL,
  `IDSede` INT NOT NULL,
  `IDMatriculaMed` INT NOT NULL,
  `DNIPaciente` INT NOT NULL,
  `Fecha` DATE NOT NULL,
  `Hora` TIME NOT NULL,
  `IDEspecialidad` INT NOT NULL,
  `Estado` TINYINT NOT NULL,
 CONSTRAINT `PK_Turnos ` PRIMARY KEY (`IDTurno`,`IDSede`,`DNIPaciente`,`IDMatriculaMed`));





 CREATE TABLE `hospitalfrenz`.`horarios` (
  `IDMatriculaMed` INT NOT NULL,
  `IDSede` INT NOT NULL,
  `IDEspecialidad` INT NOT NULL,
  `Dia` VARCHAR(10) NOT NULL,
  `Hora` TIME NOT NULL,
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
ADD CONSTRAINT `FK_Pacientes_IDProvincia` FOREIGN KEY (`IDProvinciaPaciente`) REFERENCES `provincias`(`IDProvincia`),
ADD CONSTRAINT `FK_Pacientes_IDLocalidad` FOREIGN KEY (`IDLocalidadPaciente`) REFERENCES `localidades`(`IDLocalidad`),
ADD CONSTRAINT `FK_Pacientes_DNIUser` FOREIGN KEY (`DNIPaciente`) REFERENCES `usuarios`(`DNIUser`);

ALTER TABLE `hospitalfrenz`.`localidades`
ADD CONSTRAINT `FK_Localidades_ Provincias` FOREIGN KEY (`IDProvincia`) REFERENCES `provincias`(`IDProvincia`);

ALTER TABLE `hospitalfrenz`.`Medicos`
ADD CONSTRAINT `FK_Medicos_IDProvincia` FOREIGN KEY (`IDProvinciaMed`) REFERENCES `provincias`(`IDProvincia`),
ADD CONSTRAINT `FK_Medicos_IDLocalidad` FOREIGN KEY (`IDLocalidadMed`) REFERENCES `localidades`(`IDLocalidad`),
ADD CONSTRAINT `FK_Medicos_DNIUser` FOREIGN KEY (`DNIMed`) REFERENCES `usuarios`(`DNIUser`);

ALTER TABLE `hospitalfrenz`.`sedes`
ADD CONSTRAINT `FK_Sedes_IDProvincia` FOREIGN KEY (`IDProvinciaSede`) REFERENCES `provincias`(`IDProvincia`),
ADD CONSTRAINT `FK_Sedes_IDLocalidad` FOREIGN KEY (`IDLocalidadSede`) REFERENCES `localidades`(`IDLocalidad`);




ALTER TABLE `hospitalfrenz`.`historialxpac`
ADD CONSTRAINT `FK_HistorialXPac_MatMed` FOREIGN KEY (`IDMatriculaMed`) REFERENCES `medicos`(`MatriculaMed`),
ADD CONSTRAINT `FK_HistorialXPac_DNIPac` FOREIGN KEY (`DNIPaciente`) REFERENCES `pacientes`(`DNIPaciente`),
ADD CONSTRAINT `FK_HistorialXPac_IDTurno` FOREIGN KEY (`IDTurno`) REFERENCES `turnos`(`IDTurno`),
ADD CONSTRAINT `FK_HistorialXPac_IDSede` FOREIGN KEY (`IDSede`) REFERENCES `sedes`(`IDSede`),
ADD CONSTRAINT `FK_HistorialXPac_NumEsp` FOREIGN KEY (`IDEspecialidad`) REFERENCES `especialidades`(`IDEspecialidad`);

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
