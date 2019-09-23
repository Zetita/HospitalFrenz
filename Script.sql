CREATE DATABASE `hospitalfrenz`;

CREATE TABLE `hospitalfrenz`.`usuarios` (
  `NombreUser` VARCHAR(20) NOT NULL,
  `EmailUser` VARCHAR(40) NOT NULL,
  `ContraseniaUser` VARCHAR(20) NOT NULL,
  `AdminUser` TINYINT NOT NULL,
  CONSTRAINT `PK_Usuarios ` PRIMARY KEY (`NombreUser`));

CREATE TABLE `hospitalfrenz`.`medicos` (
  `MatriculaMed` INT NOT NULL,
  `NombreMed` VARCHAR(20) NOT NULL,
  `ApellidosMed` VARCHAR(20) NOT NULL,
  `NombreUser` VARCHAR(20) NOT NULL,
  `DNIMed` INT NOT NULL,
  `DireccionMed` VARCHAR(40) NULL,
  `Localidad` VARCHAR(40) NULL,
  `ProvinciaMed` VARCHAR(40) NULL,
  `TelefonoMed` INT NOT NULL,
  `EstadoMed` TINYINT NOT NULL,
  CONSTRAINT `PK_Medicos ` PRIMARY KEY (`MatriculaMed`));

CREATE TABLE `hospitalfrenz`.`pacientes` (
  `DNIPaciente` INT NOT NULL,
  `NombrePaciente` VARCHAR(20) NOT NULL,
  `ApellidoPaciente` VARCHAR(20) NOT NULL,
  `NombreUser` VARCHAR(20) NOT NULL,
  `FechaNacPaciente` DATE NOT NULL,
  `Telefono` INT NOT NULL,
  `DireccionPaciente` VARCHAR(40) NULL,
  `LocalidadPaciente` VARCHAR(40) NULL,
  `ProvinciaPaciente` VARCHAR(40) NULL,
  `IDCobertura` INT NOT NULL,
  `EstadoPaciente` TINYINT NOT NULL,
  CONSTRAINT `PK_Paciente ` PRIMARY KEY (`DNIPaciente`));

CREATE TABLE `hospitalfrenz`.`especialidades` (
  `NumEspecialidad` INT NOT NULL,
  `DescripcionEspecialidad` VARCHAR(40) NOT NULL,
  `EstadoEspecialidad` TINYINT NOT NULL,
  CONSTRAINT `PK_Especialidades ` PRIMARY KEY (`NumEspecialidad`));

CREATE TABLE `hospitalfrenz`.`sedes` (
  `IDSede` INT NOT NULL,
  `NombreSede` VARCHAR(20) NOT NULL,
  `DireccionSede` VARCHAR(40) NOT NULL,
  `LocalidadSede` VARCHAR(40) NOT NULL,
  `ProvinciaSede` VARCHAR(40) NOT NULL,
  `Estado` TINYINT NOT NULL,
 CONSTRAINT `PK_Sedes ` PRIMARY KEY (`IDSede`));

CREATE TABLE `hospitalfrenz`.`coberturas` (
  `IDCobertura` INT NOT NULL,
  `NombreCobertura` VARCHAR(20) NOT NULL,
  `TipoCobertura` VARCHAR(20) NOT NULL,
  CONSTRAINT `PK_Coberturas ` PRIMARY KEY (`IDCobertura`));

CREATE TABLE `hospitalfrenz`.`cobxmed` (
  `IDMatriculaMed` INT NOT NULL,
  `IDCobertura` INT NOT NULL,
 CONSTRAINT `PK_CobXMed ` PRIMARY KEY (`IDMatriculaMed`, `IDCobertura`));

CREATE TABLE `hospitalfrenz`.`espxmed` (
  `IDMatriculaMed` INT NOT NULL,
  `NumEspecialidad` INT NOT NULL,
  CONSTRAINT `PK_EspXMed ` PRIMARY KEY (`IDMatriculaMed`, `NumEspecialidad`));

CREATE TABLE `hospitalfrenz`.`medxsed` (
  `IDSede` INT NOT NULL,
  `IDMatriculaMed` INT NOT NULL,
  CONSTRAINT `PK_MedXSed ` PRIMARY KEY (`IDSede`, `IDMatriculaMed`));

CREATE TABLE `hospitalfrenz`.`historialxpac` (
  `IDTurno` INT NOT NULL,
  `IDMatriculaMed` INT NOT NULL,
  `DNIPaciente` INT NOT NULL,
  `IDSede` INT NOT NULL,
  `NumEspecialidad` INT NULL,
  `Hora` TIME NOT NULL,
  `Fecha` DATE NOT NULL,
  `Estado` TINYINT NOT NULL,
  `Asistencia` TINYINT NOT NULL,
  CONSTRAINT `PK_HistorialxPac ` PRIMARY KEY (`IDTurno`,`IDSede`));

CREATE TABLE `hospitalfrenz`.`turnos` (
  `IDTurno` int(11) NOT NULL,
  `IDSede` int(11) NOT NULL,
  `IDMatriculaMed` int(11) NOT NULL,
  `DNIPaciente` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `NumEspecialidad` int(11) NOT NULL,
  `Estado` tinyint(4) NOT NULL,
 CONSTRAINT `PK_Turnos ` PRIMARY KEY (`IDTurno`,`IDSede`,`DNIPaciente`,`IDMatriculaMed`)
	);
 
ALTER TABLE `hospitalfrenz`.`espxmed`
ADD CONSTRAINT `FK_espxmed_IDMatMed` FOREIGN KEY (`IDMatriculaMed`) REFERENCES `medicos`(`MatriculaMed`),
ADD CONSTRAINT `FK_espxmed_NumEsp` FOREIGN KEY (`NumEspecialidad`) REFERENCES `especialidades`(`NumEspecialidad`);

ALTER TABLE `hospitalfrenz`.`cobxmed`
ADD CONSTRAINT `FK_CobXMed_MatMed` FOREIGN KEY (`IDMatriculaMed`) REFERENCES `medicos`(`MatriculaMed`),
ADD CONSTRAINT `FK_CobXMed_IDCob` FOREIGN KEY (`IDCobertura`) REFERENCES `coberturas`(`IDCobertura`);

ALTER TABLE `hospitalfrenz`.`medxsed`
ADD CONSTRAINT `FK_MedXSed_IDMatMed` FOREIGN KEY (`IDMatriculaMed`) REFERENCES `medicos`(`MatriculaMed`),
ADD CONSTRAINT `FK_MedXSed_IDSede` FOREIGN KEY (`IDSede`) REFERENCES `sedes`(`IDSede`);

ALTER TABLE `hospitalfrenz`.`medicos`
ADD CONSTRAINT `FK_Medicos_MedUser` FOREIGN KEY (`NombreUser`) REFERENCES `usuarios`(`NombreUser`);

ALTER TABLE `hospitalfrenz`.`pacientes`
ADD CONSTRAINT `FK_Pacientes_PacUser` FOREIGN KEY (`NombreUser`) REFERENCES `usuarios`(`NombreUser`),
ADD CONSTRAINT `FK_Pacientes_PacCob` FOREIGN KEY (`IDCobertura`) REFERENCES `coberturas`(`IDCobertura`);

ALTER TABLE `hospitalfrenz`.`historialxpac`
ADD CONSTRAINT `FK_HistorialXPac_MatMed` FOREIGN KEY (`IDMatriculaMed`) REFERENCES `medicos`(`MatriculaMed`),
ADD CONSTRAINT `FK_HistorialXPac_DNIPac` FOREIGN KEY (`DNIPaciente`) REFERENCES `pacientes`(`DNIPaciente`),
ADD CONSTRAINT `FK_HistorialXPac_Turno` FOREIGN KEY (`IDTurno`) REFERENCES `turnos`(`IDTurno`),
ADD CONSTRAINT `FK_HistorialXPac_Sede` FOREIGN KEY (`IDSede`) REFERENCES `sedes`(`IDSede`),
ADD CONSTRAINT `FK_HistorialXPac_Especialidad` FOREIGN KEY (`NumEspecialidad`) REFERENCES `especialidades`(`NumEspecialidad`);

ALTER TABLE `hospitalfrenz`.`turnos`
ADD CONSTRAINT `FK_Turnos_MatMed` FOREIGN KEY (`IDMatriculaMed`) REFERENCES `medicos`(`MatriculaMed`),
ADD CONSTRAINT `FK_Turnos_DNIPac` FOREIGN KEY (`DNIPaciente`) REFERENCES `pacientes`(`DNIPaciente`),
ADD CONSTRAINT `FK_Turnos_IDSede` FOREIGN KEY (`IDSede`) REFERENCES `sedes`(`IDSede`),
ADD CONSTRAINT `FK_Turnos_NumEsp` FOREIGN KEY (`NumEspecialidad`) REFERENCES `especialidades`(`NumEspecialidad`);
