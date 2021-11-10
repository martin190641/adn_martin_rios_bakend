SELECT id, terapia_id, fecha_hora
FROM public.terapia_detalle
WHERE terapia_id = :terapiaId;
