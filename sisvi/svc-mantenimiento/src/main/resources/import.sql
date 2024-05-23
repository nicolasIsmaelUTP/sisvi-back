-- Mantenimiento Ingreso

INSERT INTO `mantenimiento_ingreso` (`estado`, `kilometraje_ingresado`, `fecha_ingreso`, `id_chofer`, `id_vehiculo`, `observaciones`) VALUES (1, 45000, '2024-05-01', 1, 1, 'Cambio de aceite y filtro');

INSERT INTO `mantenimiento_ingreso` (`estado`, `kilometraje_ingresado`, `fecha_ingreso`, `id_chofer`, `id_vehiculo`, `observaciones`) VALUES (1, 23000, '2024-05-02', 2, 2, 'Revisión de frenos y pastillas');

INSERT INTO `mantenimiento_ingreso` (`estado`, `kilometraje_ingresado`, `fecha_ingreso`, `id_chofer`, `id_vehiculo`, `observaciones`) VALUES (1, 78000, '2024-05-03', 3, 3, 'Cambio de neumáticos');

INSERT INTO `mantenimiento_ingreso` (`estado`, `kilometraje_ingresado`, `fecha_ingreso`, `id_chofer`, `id_vehiculo`, `observaciones`) VALUES (1, 50000, '2024-05-04', 4, 4, 'Revisión del sistema de suspensión');

INSERT INTO `mantenimiento_ingreso` (`estado`, `kilometraje_ingresado`, `fecha_ingreso`, `id_chofer`, `id_vehiculo`, `observaciones`) VALUES (1, 12000, '2024-05-05', 5, 5, 'Ajuste de frenos y alineación');

INSERT INTO `mantenimiento_ingreso` (`estado`, `kilometraje_ingresado`, `fecha_ingreso`, `id_chofer`, `id_vehiculo`, `observaciones`) VALUES (1, 95000, '2024-05-06', 6, 6, 'Reemplazo de batería');

INSERT INTO `mantenimiento_ingreso` (`estado`, `kilometraje_ingresado`, `fecha_ingreso`, `id_chofer`, `id_vehiculo`, `observaciones`) VALUES (1, 8000, '2024-05-07', 7, 7, 'Revisión general y cambio de aceite');

INSERT INTO `mantenimiento_ingreso` (`estado`, `kilometraje_ingresado`, `fecha_ingreso`, `id_chofer`, `id_vehiculo`, `observaciones`) VALUES (1, 120000, '2024-05-08', 8, 8, 'Cambio de correa de distribución');

INSERT INTO `mantenimiento_ingreso` (`estado`, `kilometraje_ingresado`, `fecha_ingreso`, `id_chofer`, `id_vehiculo`, `observaciones`) VALUES (1, 5000, '2024-05-09', 9, 9, 'Revisión del sistema eléctrico');

INSERT INTO `mantenimiento_ingreso` (`estado`, `kilometraje_ingresado`, `fecha_ingreso`, `id_chofer`, `id_vehiculo`, `observaciones`) VALUES (1, 150000, '2024-05-10', 10, 10, 'Reemplazo de radiador y mangueras');

-- Mantenimiento Salida

INSERT INTO `mantenimiento_salida` (`estado`, `kilometraje_salida`, `nivel_aceite`, `nivel_combustible`, `nivel_danio`, `fecha_salida`, `mantenimiento_ingreso_id`, `observaciones`) VALUES (1, 45500, 5, 8, 1, '2024-05-11', 1, 'Cambio de aceite completado');

INSERT INTO `mantenimiento_salida` (`estado`, `kilometraje_salida`, `nivel_aceite`, `nivel_combustible`, `nivel_danio`, `fecha_salida`, `mantenimiento_ingreso_id`, `observaciones`) VALUES (1, 23500, 5, 7, 1, '2024-05-12', 2, 'Pastillas de freno nuevas');

INSERT INTO `mantenimiento_salida` (`estado`, `kilometraje_salida`, `nivel_aceite`, `nivel_combustible`, `nivel_danio`, `fecha_salida`, `mantenimiento_ingreso_id`, `observaciones`) VALUES (1, 78500, 5, 9, 0, '2024-05-13', 3, 'Neumáticos reemplazados');

INSERT INTO `mantenimiento_salida` (`estado`, `kilometraje_salida`, `nivel_aceite`, `nivel_combustible`, `nivel_danio`, `fecha_salida`, `mantenimiento_ingreso_id`, `observaciones`) VALUES (1, 50500, 5, 8, 0, '2024-05-14', 4, 'Suspensión revisada y ajustada');

INSERT INTO `mantenimiento_salida` (`estado`, `kilometraje_salida`, `nivel_aceite`, `nivel_combustible`, `nivel_danio`, `fecha_salida`, `mantenimiento_ingreso_id`, `observaciones`) VALUES (1, 12500, 5, 7, 0, '2024-05-15', 5, 'Frenos ajustados y alineación completada');

INSERT INTO `mantenimiento_salida` (`estado`, `kilometraje_salida`, `nivel_aceite`, `nivel_combustible`, `nivel_danio`, `fecha_salida`, `mantenimiento_ingreso_id`, `observaciones`) VALUES (1, 95500, 5, 9, 1, '2024-05-16', 6, 'Batería reemplazada con éxito');

INSERT INTO `mantenimiento_salida` (`estado`, `kilometraje_salida`, `nivel_aceite`, `nivel_combustible`, `nivel_danio`, `fecha_salida`, `mantenimiento_ingreso_id`, `observaciones`) VALUES (1, 8500, 5, 8, 0, '2024-05-17', 7, 'Revisión general y cambio de aceite completado');

INSERT INTO `mantenimiento_salida` (`estado`, `kilometraje_salida`, `nivel_aceite`, `nivel_combustible`, `nivel_danio`, `fecha_salida`, `mantenimiento_ingreso_id`, `observaciones`) VALUES (1, 120500, 5, 6, 2, '2024-05-18', 8, 'Correa de distribución reemplazada');

INSERT INTO `mantenimiento_salida` (`estado`, `kilometraje_salida`, `nivel_aceite`, `nivel_combustible`, `nivel_danio`, `fecha_salida`, `mantenimiento_ingreso_id`, `observaciones`) VALUES (1, 5500, 5, 9, 0, '2024-05-19', 9, 'Sistema eléctrico revisado');

INSERT INTO `mantenimiento_salida` (`estado`, `kilometraje_salida`, `nivel_aceite`, `nivel_combustible`, `nivel_danio`, `fecha_salida`, `mantenimiento_ingreso_id`, `observaciones`) VALUES (1, 150500, 5, 7, 2, '2024-05-20', 10, 'Radiador y mangueras reemplazadas');
