INSERT INTO `viajes` (`estado`, `conductor_id`, `fecha_hora_fin`, `fecha_hora_inicio`, `vehiculo_id`, `ubicacion_fin`, `ubicacion_inicio`) VALUES (1, 1, '2024-07-01 10:30:00', '2024-07-01 09:00:00', 1, 'Location A', 'Location B');
INSERT INTO `viajes` (`estado`, `conductor_id`, `fecha_hora_fin`, `fecha_hora_inicio`, `vehiculo_id`, `ubicacion_fin`, `ubicacion_inicio`) VALUES (1, 2, '2024-07-01 11:00:00', '2024-07-01 10:00:00', 2, 'Location C', 'Location D');
INSERT INTO `viajes` (`estado`, `conductor_id`, `fecha_hora_fin`, `fecha_hora_inicio`, `vehiculo_id`, `ubicacion_fin`, `ubicacion_inicio`) VALUES (1, 3, '2024-07-02 12:30:00', '2024-07-02 11:00:00', 3, 'Location E', 'Location F');
INSERT INTO `viajes` (`estado`, `conductor_id`, `fecha_hora_fin`, `fecha_hora_inicio`, `vehiculo_id`, `ubicacion_fin`, `ubicacion_inicio`) VALUES (1, 4, '2024-07-02 14:00:00', '2024-07-02 13:00:00', 4, 'Location G', 'Location H');
INSERT INTO `viajes` (`estado`, `conductor_id`, `fecha_hora_fin`, `fecha_hora_inicio`, `vehiculo_id`, `ubicacion_fin`, `ubicacion_inicio`) VALUES (1, 5, '2024-07-03 15:30:00', '2024-07-03 14:00:00', 5, 'Location I', 'Location J');
INSERT INTO `viajes` (`estado`, `conductor_id`, `fecha_hora_fin`, `fecha_hora_inicio`, `vehiculo_id`, `ubicacion_fin`, `ubicacion_inicio`) VALUES (1, 6, '2024-07-03 17:00:00', '2024-07-03 16:00:00', 6, 'Location K', 'Location L');
INSERT INTO `viajes` (`estado`, `conductor_id`, `fecha_hora_fin`, `fecha_hora_inicio`, `vehiculo_id`, `ubicacion_fin`, `ubicacion_inicio`) VALUES (1, 7, '2024-07-04 18:30:00', '2024-07-04 17:00:00', 7, 'Location M', 'Location N');
INSERT INTO `viajes` (`estado`, `conductor_id`, `fecha_hora_fin`, `fecha_hora_inicio`, `vehiculo_id`, `ubicacion_fin`, `ubicacion_inicio`) VALUES (1, 8, '2024-07-04 20:00:00', '2024-07-04 19:00:00', 8, 'Location O', 'Location P');
INSERT INTO `viajes` (`estado`, `conductor_id`, `fecha_hora_fin`, `fecha_hora_inicio`, `vehiculo_id`, `ubicacion_fin`, `ubicacion_inicio`) VALUES (1, 9, '2024-07-05 21:30:00', '2024-07-05 20:00:00', 9, 'Location Q', 'Location R');
INSERT INTO `viajes` (`estado`, `conductor_id`, `fecha_hora_fin`, `fecha_hora_inicio`, `vehiculo_id`, `ubicacion_fin`, `ubicacion_inicio`) VALUES (1, 10, '2024-07-05 23:00:00', '2024-07-05 22:00:00', 10, 'Location S', 'Location T');

INSERT INTO `infracciones` (`estado`, `viaje_id`, `fecha_registro`, `observaciones`, `ubicacion`) VALUES (1, 1, '2024-07-01 09:30:00', 'Speeding', 'Location A');
INSERT INTO `infracciones` (`estado`, `viaje_id`, `fecha_registro`, `observaciones`, `ubicacion`) VALUES (1, 2, '2024-07-01 10:30:00', 'Running a red light', 'Location B');
INSERT INTO `infracciones` (`estado`, `viaje_id`, `fecha_registro`, `observaciones`, `ubicacion`) VALUES (1, 3, '2024-07-02 11:30:00', 'Illegal parking', 'Location C');

INSERT INTO `averias` (`estado`, `fecha_registro`, `viaje_id`, `observaciones`, `tipo`, `ubicacion`) VALUES (1, '2024-07-01 10:00:00', 1, 'Engine overheating', 'Engine', 'Location D');
INSERT INTO `averias` (`estado`, `fecha_registro`, `viaje_id`, `observaciones`, `tipo`, `ubicacion`) VALUES (1, '2024-07-02 11:00:00', 2, 'Flat tire', 'Tire', 'Location E');
INSERT INTO `averias` (`estado`, `fecha_registro`, `viaje_id`, `observaciones`, `tipo`, `ubicacion`) VALUES (1, '2024-07-03 12:00:00', 3, 'Brake failure', 'Brake', 'Location F');