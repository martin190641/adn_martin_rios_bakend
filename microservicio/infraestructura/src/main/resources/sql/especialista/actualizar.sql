UPDATE public.especialista
SET documento_identificacion = :documentoIdentificacion,
 nombres = :nombres,
 apellidos = :apellidos,
 fecha_nacimiento = :fechaNacimiento,
 estado = :estado
WHERE id = :id
