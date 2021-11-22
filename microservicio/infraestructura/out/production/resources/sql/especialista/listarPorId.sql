SELECT id, documento_identificacion, nombres, apellidos, fecha_nacimiento, estado
FROM public.especialista
WHERE id = :id;