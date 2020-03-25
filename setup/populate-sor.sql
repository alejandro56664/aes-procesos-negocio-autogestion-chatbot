--limpiamos las tablas
DELETE FROM tipo_servicio_contratable;
DELETE FROM servicio_contratado;
DELETE FROM estado_servicio_contratado;

--insertamos la data de pruebas
INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (1, 30, 'Servicio movil, pospago, corte 30. Incluye: 30GB Datos, Minutos ilimitados, SMS ilimitados', 59000, 1);
	
INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (2, 30, 'Servicio movil, pospago, corte 30. Incluye: 20GB Datos, 700 Minutos, SMS ilimitados', 49000, 1);

INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (3, 12, 'Servicio movil, pospago, corte 12. Incluye: 10GB Datos, 700 Minutos, SMS ilimitados', 39000, 1);
	
INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (4, 11, 'Servicio movil, pospago, corte 11. Incluye: 10GB Datos , 700 Minutos, SMS ilimitados', 39000, 1);
	
INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (5, 11, 'Servicio movil, pospago, corte 11. Incluye: 10GB Datos, Minutos ilimitados, SMS ilimitados', 43000, 1);
	
INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (6, 12, 'Servicio movil, pospago, corte 12. Incluye: 20GB Datos', 33000, 1);
	
INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (7, 28, 'Trío premium', 149000, 2);

INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (8, 28, 'Dúo premium', 129000, 2);

INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (9, 28, 'Internet premium', 129000, 2);
	
INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (10, 28, 'Solo TV', 39000, 2);

INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (11, 28, 'Trío clásico', 99000, 2);

INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (12, 28, 'Dúo clásico', 79000, 2);

INSERT INTO public.tipo_servicio_contratable(
	id, corte, descripcion, valor, categoria)
	VALUES (13, 28, 'Internet clásico', 39000, 2);

--Data para el 1096035437
--Servicio fijo
INSERT INTO public.servicio_contratado(
	id, fecha_alta, id_servicio, tipo_servicio_contratable_id)
	VALUES (11, '11/02/2017', '0318340958', 13);
	
	
INSERT INTO public.estado_servicio_contratado(
	id, descripcion, estado, "timestamp", id_servicio)
	VALUES (11, 'alta usuario', 'ACTIVO', '12/02/2017', 11);

--Data para el 1096035438
--Servicio fijo
INSERT INTO public.servicio_contratado(
	id, fecha_alta, id_servicio, tipo_servicio_contratable_id)
	VALUES (10, '12/02/2017', '0318340957', 10);
	
	
INSERT INTO public.estado_servicio_contratado(
	id, descripcion, estado, "timestamp", id_servicio)
	VALUES (10, 'alta usuario', 'ACTIVO', '12/02/2017', 10);
	
--Data para el 1096035439
--Servicio fijo
INSERT INTO public.servicio_contratado(
	id, fecha_alta, id_servicio, tipo_servicio_contratable_id)
	VALUES (9, '13/02/2017', '0318340956', 10);
	
	
INSERT INTO public.estado_servicio_contratado(
	id, descripcion, estado, "timestamp", id_servicio)
	VALUES (9, 'alta usuario', 'ACTIVO', '13/02/2017', 10);
	
--Data para el 1096035440
--Servicio fijo
INSERT INTO public.servicio_contratado(
	id, fecha_alta, id_servicio, tipo_servicio_contratable_id)
	VALUES (8, '14/02/2017', '0318340955', 9);
	
	
INSERT INTO public.estado_servicio_contratado(
	id, descripcion, estado, "timestamp", id_servicio)
	VALUES (8, 'alta usuario', 'ACTIVO', '14/02/2017', 8);
	
--Data para el 1096035441
--Servicio fijo
INSERT INTO public.servicio_contratado(
	id, fecha_alta, id_servicio, tipo_servicio_contratable_id)
	VALUES (7, '14/02/2017', '0318340954', 7);
	
	
INSERT INTO public.estado_servicio_contratado(
	id, descripcion, estado, "timestamp", id_servicio)
	VALUES (7, 'alta usuario', 'ACTIVO', '14/02/2017', 7);
	

--Data para 1096035442
INSERT INTO public.servicio_contratado(
	id, fecha_alta, id_servicio, tipo_servicio_contratable_id)
	VALUES (6, '15/02/2017', '3176455488', 6);
	
	
INSERT INTO public.estado_servicio_contratado(
	id, descripcion, estado, "timestamp", id_servicio)
	VALUES (6, 'alta usuario', 'ACTIVO', '15/02/2017', 6);
	
--Data para 1096035443
INSERT INTO public.servicio_contratado(
	id, fecha_alta, id_servicio, tipo_servicio_contratable_id)
	VALUES (5, '16/02/2017', '3176455489', 5);
	
INSERT INTO public.estado_servicio_contratado(
	id, descripcion, estado, "timestamp", id_servicio)
	VALUES (5, 'alta usuario', 'ACTIVO', '16/02/2017', 5);
	
--Data para 1096035444
INSERT INTO public.servicio_contratado(
	id, fecha_alta, id_servicio, tipo_servicio_contratable_id)
	VALUES (4, '17/02/2017', '3176455490', 4);
	
INSERT INTO public.estado_servicio_contratado(
	id, descripcion, estado, "timestamp", id_servicio)
	VALUES (4, 'alta usuario', 'ACTIVO', '17/02/2017', 4);
	
--Data para 1096035445
	
INSERT INTO public.servicio_contratado(
	id, fecha_alta, id_servicio, tipo_servicio_contratable_id)
	VALUES (3, '18/02/2017', '3176455491', 3);
	
INSERT INTO public.estado_servicio_contratado(
	id, descripcion, estado, "timestamp", id_servicio)
	VALUES (3, 'alta usuario', 'ACTIVO', '18/02/2017', 3);

--Data para 1096035446
INSERT INTO public.servicio_contratado(
	id, fecha_alta, id_servicio, tipo_servicio_contratable_id)
	VALUES (2, '19/02/2017', '3176455492', 2);

INSERT INTO public.estado_servicio_contratado(
	id, descripcion, estado, "timestamp", id_servicio)
	VALUES (2, 'alta usuario', 'ACTIVO', '19/02/2017', 2);
	
	
--Data para 1096035447
INSERT INTO public.servicio_contratado(
	id, fecha_alta, id_servicio, tipo_servicio_contratable_id)
	VALUES (1, '20/02/2017', '3176455493', 1);
	
INSERT INTO public.estado_servicio_contratado(
	id, descripcion, estado, "timestamp", id_servicio)
	VALUES (1, 'alta usuario', 'ACTIVO', '20/02/2017', 1);
	

	
	
	
--agregamos data para los inactivos

INSERT INTO public.estado_servicio_contratado(
	id, codigo, estado, descripcion, "timestamp", id_servicio)
	VALUES (12, 'AVERIA', 'INACTIVO', '', '20/03/2020', 1);
	

INSERT INTO public.estado_servicio_contratado(
	id, codigo, estado, descripcion, "timestamp", id_servicio)
	VALUES (13, 'AVERIA', 'INACTIVO', '', '19/03/2020', 2);

INSERT INTO public.estado_servicio_contratado(
	id, codigo, estado, descripcion, "timestamp", id_servicio)
	VALUES (14, 'FINANCIERO', 'SUSPENDIDO_PYS', 'el servicio se encuentra actualemnte a paz y salvo, pendiente de reactivación.', '18/03/2020', 3);
	
		
INSERT INTO public.estado_servicio_contratado(
	id, codigo, estado, descripcion, "timestamp", id_servicio)
	VALUES (15, 'FINANCIERO', 'SUSPENDIDO', 'suspendido por falta de pago', '17/03/2020', 4);
	
INSERT INTO public.estado_servicio_contratado(
	id, codigo, estado, descripcion, "timestamp", id_servicio)
	VALUES (16, 'HADA', 'BLOQUEADO', 'bloqueado por que se ha detectado mal uso del servicio.', '16/03/2020', 5);
	
--agregamos data para los inactivos, fijos

INSERT INTO public.estado_servicio_contratado(
	id, codigo, estado, descripcion, "timestamp", id_servicio)
	VALUES (17, 'AVERIA', 'INACTIVO', '', '21/03/2020', 7);
	
--agregamos data para los inactivos, fijos

INSERT INTO public.estado_servicio_contratado(
	id, codigo, estado, descripcion, "timestamp", id_servicio)
	VALUES (18, 'AVERIA', 'INACTIVO', '', '21/03/2020', 8);
	
--agregamos data para los inactivos, fijos

INSERT INTO public.estado_servicio_contratado(
	id, codigo, estado, descripcion, "timestamp", id_servicio)
	VALUES (19, 'AVERIA', 'INACTIVO', '', '22/03/2020', 9);
	
--agregamos data para los inactivos, fijos

INSERT INTO public.estado_servicio_contratado(
	id, codigo, estado, descripcion, "timestamp", id_servicio)
	VALUES (20, 'AVERIA', 'INACTIVO', '', '22/03/2020', 10);
	
INSERT INTO public.estado_servicio_contratado(
	id, codigo, estado, descripcion, "timestamp", id_servicio)
	VALUES (21, 'AVERIA', 'INACTIVO', '', '22/03/2020', 11);
	
--agregamos incidencias fake para el cliente 1096035446 linea 3176455492
INSERT INTO public.incidencia(
	id, actualizado_por, canal, descripcion, estado, fecha_actualizacion, registrado_por, "timestamp", tipo_incidencia, titulo, id_servicio, fecha_estimada_resolucion)
	VALUES (1, 'autogestion-bot', 'whatsapp', 'Se registra falla en el registro del dispositivo a la red celular', 'ABIERTA', '22/03/2020', 'autogestion-bot', '22/03/2020', 'AVERIA', 'Falla registro dispositivo en la red', 2, '25/03/2020');
	

--insertamos una peticion para: 0318340954
INSERT INTO public.incidencia(
	id, actualizado_por, canal, descripcion, estado, fecha_actualizacion, registrado_por, "timestamp", tipo_incidencia, titulo, id_servicio, fecha_estimada_resolucion)
	VALUES (2, 'autogestion-bot', 'whatsapp', 'Se registra falla en el registro del dispositivo a la red', 'ABIERTA', '23/03/2020', 'autogestion-bot', '23/03/2020', 'PETICION', 'Falla registro dispositivo en la red', 7, '25/03/2020');
	

--insertamos falla masiva que afecta a: 0318340955
INSERT INTO public.falla_masiva(
	id, actualizado_por, descripcion, estado, fecha_actualizacion, fecha_estimada_resolucion, "timestamp")
	VALUES (1, 'autogestion-bot', 'Falla por robo de cable en el sector Bochica III, Engativá, Bogotá', 'ABIERTA', '22/03/2020', '23/03/2020', '22/03/2020');
	
INSERT INTO public.afectado_falla_masiva(
	id, id_servicio, id_falla_masiva)
	VALUES (1, '0318340955', 1);