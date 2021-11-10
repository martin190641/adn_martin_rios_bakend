UPDATE public.paciente
SET documento_identificacion = :documentoIdentificacion,
 nombres = :nombres,
 apellidos = :apellidos,
 fecha_nacimiento = :fechaNacimiento
WHERE id = :id
