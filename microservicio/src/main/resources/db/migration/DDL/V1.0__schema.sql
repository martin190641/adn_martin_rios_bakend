CREATE TABLE IF NOT EXISTS public.tipo_servicio (
  id serial PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  descripcion  VARCHAR(600) NOT NULL,
  valor NUMERIC(17, 2) NOT NULL
);

INSERT INTO public.tipo_servicio (nombre, descripcion, valor)
VALUES ('TERAPIA DEL LENGUAJE', 'El profesional encargado para brindar este servicio es el fonoaudiólogo quien se encarga de abordar científicamente la comunicación interpersonal,  oral,  lecto-escrita  y  gestual;  y  las  alteraciones  que  en ella  se  presentan  por  factores  de  naturaleza  ambiental,  biológica, icológica  y/o  social  en  las  diferentes  áreas  que  la  constituyen:  el habla  (voz,  articulación,  fluidez,  procesos  miofuncionales  y  deglución, entre otros); el lenguaje (comprensión y expresión) y la audición.', 150000),
('TERAPIA  FÍSICA', 'Este  servicio  está  a  cargo  de  los  fisioterapeutas,  ya  que  son  los profesionales encargados del manejo del movimiento corporal humano en  todas  las  etapas  de  la  vida.  Sus  acciones  se  encaminan  tanto  a mantener  y  potencializar  el  movimiento  corporal  humano,  como  a prevenir  y  rehabilitar  sus  alteraciones.', 120000),
('FISIATRÍA', 'La  Medicina  Física  y  Rehabilitación  – Fisiatría - es una especialidad  médica  con  campos  de  acción  definidos  en  la promoción  de  la  salud  y  en  la  prevención  de  la  enfermedad, diagnóstico  y  tratamiento  del  paciente  discapacitado,  teniendo como meta el mejoramiento de la calidad de vida, a través de la intervención  profesional  apoyada  en  bases  científicas,  éticas  y humanísticas.', 135000);



CREATE TABLE IF NOT EXISTS public.especialista (
 id serial PRIMARY KEY,
 documento_identificacion VARCHAR(15) NOT NULL unique,
 nombres VARCHAR(50) NOT NULL,
 apellidos VARCHAR(50) NOT NULL,
 fecha_nacimiento date NOT NULL,
 estado BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS public.paciente (
 id serial PRIMARY KEY,
 documento_identificacion VARCHAR(15) NOT NULL unique,
 nombres VARCHAR(50) NOT NULL,
 apellidos VARCHAR(50) NOT NULL,
 fecha_nacimiento date NOT NULL
);

CREATE TABLE IF NOT EXISTS public.terapia (
  id serial primary key,
  paciente_id  INT NOT NULL,
  tipo_servicio_id INT NOT NULL,
  especialista_id INT NOT NULL,
  fecha_terapia DATE NOT NULL,
  descuento INT NOT NULL,
  valor_neto  NUMERIC(17, 2) NOT NULL,
  valor_total NUMERIC(17, 2) NOT NULL,
  FOREIGN KEY (paciente_id)
    REFERENCES paciente (id),
  FOREIGN KEY (tipo_servicio_id)
    REFERENCES tipo_servicio (id),
  FOREIGN KEY (especialista_id)
    REFERENCES especialista (id)
);

CREATE TABLE IF NOT EXISTS public.terapia_detalle (
id serial NOT NULL,
terapia_id INT NOT NULL,
fecha_hora TIMESTAMP,
  PRIMARY KEY (id, terapia_id),
  FOREIGN KEY (terapia_id)
      REFERENCES terapia (id)
);

CREATE TABLE IF NOT EXISTS public.festividad (
  fecha_festiva DATE PRIMARY KEY,
  descripcion  VARCHAR(100) NOT NULL
);

INSERT INTO public.festividad (fecha_festiva, descripcion)
VALUES ('2021-01-01', 'Año Nuevo'),
	('2021-01-11', 'Día de los Reyes Magos'),
	('2021-03-22', 'Día de San José'),
	('2021-04-01', 'Jueves Santo'),
	('2021-04-02', 'Viernes Santo'),
	('2021-05-01', 'Día del Trabajador'),
	('2021-05-17', 'Día de la Ascensión'),
	('2021-06-07', 'Día del Corpus Christi'),
	('2021-06-14', 'Día del Sagrado Corazón'),
	('2021-07-05', 'Día de San Pedro y San Pablo'),
	('2021-07-20', 'Día de la Independencia'),
	('2021-08-07', 'Batalla de Boyacá'),
	('2021-08-16', 'La Asunción de la virgen'),
	('2021-10-10', 'Día de la Raza'),
	('2021-11-01', 'Día de los Difuntos'),
	('2021-11-15', 'Independencia de Cartagena'),
	('2021-12-08', 'Día de la Inmaculada Concepción'),
	('2021-12-25', 'Navidad'),
	('2022-01-01', 'Año Nuevo'),
	('2022-01-10', 'Día de los Reyes Magos'),
	('2022-03-21', 'Día de San José'),
	('2022-04-14', 'Jueves Santo'),
	('2022-04-15', 'Viernes Santo'),
	('2022-05-01', 'Día del Trabajador'),
	('2022-05-30', 'Día de la Ascensión'),
	('2022-06-20', 'Día del Corpus Christi'),
	('2022-06-27', 'Día del Sagrado Corazón'),
	('2022-07-04', 'Día de San Pedro y San Pablo'),
	('2022-07-20', 'Día de la Independencia'),
	('2022-08-07', 'Batalla de Boyacá'),
	('2022-08-15', 'La Asunción de la virgen'),
	('2022-10-17', 'Día de la Raza'),
	('2022-11-07', 'Día de los Difuntos'),
	('2022-11-14', 'Independencia de Cartagena'),
	('2022-12-08', 'Día de la Inmaculada Concepción'),
	('2022-12-25', 'Navidad');

