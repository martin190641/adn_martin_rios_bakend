SELECT id, paciente_id, tipo_servicio_id, especialista_id, fecha_terapia, descuento, valor_neto, valor_total
FROM public.terapia
WHERE paciente_id = :pacienteId;
