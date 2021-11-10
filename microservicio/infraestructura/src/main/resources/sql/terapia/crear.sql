INSERT INTO public.terapia
(paciente_id, tipo_servicio_id, especialista_id, fecha_terapia, descuento, valor_neto, valor_total)
VALUES(:pacienteId, :tipoServicioId, :especialistaId, :fechaTerapia, :descuento, :valorNeto, :valorTotal);
