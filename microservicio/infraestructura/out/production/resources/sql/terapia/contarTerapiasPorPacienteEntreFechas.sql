SELECT COUNT(*)
FROM public.terapia
WHERE paciente_id = :pacienteId AND fecha_terapia BETWEEN :fechaInicial AND :fechaFinal;
