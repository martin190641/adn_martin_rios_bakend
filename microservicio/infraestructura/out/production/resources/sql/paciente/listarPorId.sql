SELECT id, documento_identificacion, nombres, apellidos, fecha_nacimiento
FROM public.paciente
WHERE id = :id;