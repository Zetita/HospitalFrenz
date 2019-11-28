INSERT INTO `hospitalfrenz`.`medicos` 
(`DNIMed`, `MatriculaMed`, `NombreMed`, `ApellidosMed`, `DireccionMed`, `IDLocalidad`, `TelefonoMed`, `EstadoMed`) 
VALUES ('17.123.123', '11111111', 'Martha', 'Torres Hidalgo', 'Carlos Pellegrini 2700', '2510', '15-1234-1234', '1');

INSERT INTO `hospitalfrenz`.`coberturas`
(`IDCobertura`,`NombreCobertura`,`TipoCobertura`,`CostoCobertura`,`DescripcionCobertura`)
VALUES('1','Cobertura UNO',"Coberturita 1", 2500,'-');

INSERT INTO `hospitalfrenz`.`pacientes`
(`DNIPaciente`,`NombrePaciente`,`ApellidoPaciente`, `FechaNacPaciente`,`Telefono`,`DireccionPaciente`,`IDLocalidad`,`IDCobertura`,`EstadoPaciente`) 
VALUES
('35.000.350','Alexis Fernando','Maqueda','1990-10-10','15-1111-2222', 'Chacabuco 333','12565','1','1');

INSERT INTO `hospitalfrenz`.`usuarios` (`NombreUser`, `EmailUser`, `DNIUser`, `ContraseniaUser`, `TipoUser`, `EstadoUser`) 
VALUES ('admin', 'admin@admin.com', '00.000.000', 'admin', 'adm', TRUE);

INSERT INTO `hospitalfrenz`.`usuarios` (`NombreUser`, `EmailUser`, `DNIUser`, `ContraseniaUser`, `TipoUser`, `EstadoUser`) 
VALUES ('martha.th', 'martha@yahoo.com', '17.123.123', '12345', 'med', TRUE);

