INSERT INTO `hospitalfrenz`.`medicos` 
(`DNIMed`, `MatriculaMed`, `NombreMed`, `ApellidosMed`, `DireccionMed`, `IDLocalidad`, `TelefonoMed`, `EstadoMed`) 
VALUES ('17.123.123', '11111111', 'Martha', 'Torres Hidalgo', 'Carlos Pellegrini 2700', '2510', '15-1234-1234', '1');
INSERT INTO `hospitalfrenz`.`medicos` 
(`DNIMed`, `MatriculaMed`, `NombreMed`, `ApellidosMed`, `DireccionMed`, `IDLocalidad`, `TelefonoMed`, `EstadoMed`) 
VALUES ('20.000.000', '11111112', 'Alberto', 'Romero', 'Ricardo Gutiérrez 2001', '17298', '15-2121-2121', '1');
INSERT INTO `hospitalfrenz`.`medicos` 
(`DNIMed`, `MatriculaMed`, `NombreMed`, `ApellidosMed`, `DireccionMed`, `IDLocalidad`, `TelefonoMed`, `EstadoMed`) 
VALUES ('25.122.221', '61111413', 'Alexandra Marcela', 'Ballarini', 'Gral. Juan Lavalle 1227', '17299', '15-2020-3030', '1');

INSERT INTO `hospitalfrenz`.`espxmed`(`IDMatriculaMed`, `IDEspecialidad`, `EstadoEspxMed`) VALUES(11111111,2,1);
INSERT INTO `hospitalfrenz`.`espxmed`(`IDMatriculaMed`, `IDEspecialidad`, `EstadoEspxMed`) VALUES(11111112,2,1);

INSERT INTO `hospitalfrenz`.`pacientes`
(`DNIPaciente`,`NombrePaciente`,`ApellidoPaciente`, `FechaNacPaciente`,`Telefono`,`DireccionPaciente`,`IDLocalidad`,`IDCobertura`,`EstadoPaciente`) 
VALUES('35.000.350','Alexis Fernando','Maqueda','1990-10-10','15-1111-2222', 'Chacabuco 333','12565','1','1');
INSERT INTO `hospitalfrenz`.`pacientes`
(`DNIPaciente`,`NombrePaciente`,`ApellidoPaciente`, `FechaNacPaciente`,`Telefono`,`DireccionPaciente`,`IDLocalidad`,`IDCobertura`,`EstadoPaciente`) 
VALUES('40.020.222','Carolina','Aguirre','1997-05-09','15-1114-2722', 'Chacabuco 111','12565','1','1');


INSERT INTO `hospitalfrenz`.`turnos` 
(`IDTurno`, `IDSede`, `IDMatriculaMed`, `DNIPaciente`, `Fecha`, `Hora`, `IDEspecialidad`, `Estado`, `Asistencia`) 
VALUES ('1', '2', '11111112', '40.020.222', '2019-10-25', '08:00:00', '2', '0', '-1');
INSERT INTO `hospitalfrenz`.`turnos` 
(`IDTurno`, `IDSede`, `IDMatriculaMed`, `DNIPaciente`, `Fecha`, `Hora`, `IDEspecialidad`, `Estado`, `Asistencia`) 
VALUES ('2', '1', '11111111', '35.000.350', '2019-12-10', '10:00:00', '2', '1', '0');
INSERT INTO `hospitalfrenz`.`turnos` 
(`IDTurno`, `IDSede`, `IDMatriculaMed`, `DNIPaciente`, `Fecha`, `Hora`, `IDEspecialidad`, `Estado`, `Asistencia`) 
VALUES ('3', '1', '11111111', '40.020.222', '2020-01-25', '16:00:00', '2', '1', '0');
INSERT INTO `hospitalfrenz`.`turnos` 
(`IDTurno`, `IDSede`, `IDMatriculaMed`, `DNIPaciente`, `Fecha`, `Hora`, `IDEspecialidad`, `Estado`, `Asistencia`) 
VALUES ('4', '1', '11111111', '35.000.350', '2020-01-25', '10:30:00', '2', '1', '0');



INSERT INTO `hospitalfrenz`.`usuarios` (`NombreUser`, `EmailUser`, `DNIUser`, `ContraseniaUser`, `TipoUser`, `EstadoUser`) 
VALUES ('admin', 'admin@admin.com', '00.000.000', 'admin', 'Administrador', TRUE);
INSERT INTO `hospitalfrenz`.`usuarios` (`NombreUser`, `EmailUser`, `DNIUser`, `ContraseniaUser`, `TipoUser`, `EstadoUser`) 
VALUES ('martha.th', 'martha@yahoo.com', '17.123.123', '12345', 'Medico', TRUE);
INSERT INTO `hospitalfrenz`.`usuarios` (`NombreUser`, `EmailUser`, `DNIUser`, `ContraseniaUser`, `TipoUser`, `EstadoUser`) 
VALUES ('alexis.m', 'alexis.m@gmail.com', '35.000.350', '1212', 'Paciente', TRUE);
