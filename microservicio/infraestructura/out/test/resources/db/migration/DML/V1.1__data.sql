INSERT INTO public.paciente (documento_identificacion, nombres, apellidos, fecha_nacimiento) VALUES('1234567890', 'test nombres', 'test apellidos', now());
INSERT INTO public.tipo_servicio (nombre, descripcion, valor)
VALUES ('Test Servicio', 'Test desripcion Servicio', 150000);
INSERT INTO public.especialista (documento_identificacion, nombres, apellidos, fecha_nacimiento, estado) VALUES('1234567890', 'test nombres', 'test apellidos', now(), true);
INSERT INTO public.terapia
(paciente_id, tipo_servicio_id, especialista_id, fecha_terapia, descuento, valor_neto, valor_total)
VALUES(1, 1, 1, now(), 0, 150000, 150000);
INSERT INTO public.terapia_detalle
(terapia_id, fecha_hora)
VALUES(1, now());


